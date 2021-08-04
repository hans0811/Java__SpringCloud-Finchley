package com.hans.order.service.impl;

import com.hans.order.client.ProductClient;
import com.hans.order.dataobject.OrderDetail;
import com.hans.order.dataobject.OrderMaster;
import com.hans.order.dataobject.ProductInfo;
import com.hans.order.dto.CartDTO;
import com.hans.order.dto.OrderDTO;
import com.hans.order.enums.OrderStatusEnum;
import com.hans.order.enums.PayStatusEnum;
import com.hans.order.repo.OrderDetailRepository;
import com.hans.order.repo.OrderMasterRepository;
import com.hans.order.service.OrderService;
import com.hans.order.utils.KeyUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hans
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
//      * 2. search item information
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.ListForOrder(productIdList);

//      * 3. total price
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for(ProductInfo productInfo:productInfoList){
                // check 2 ID is the same
                if (productInfo.getProductId().equals(orderDetail.getProductId())){
                    // price * quantity
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    // write order in db
                    orderDetailRepository.save(orderDetail);
                }

            }

        }
//     * 4. decrease stock
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);


//     * 5. order to db
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
