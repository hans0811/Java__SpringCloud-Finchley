package com.hans.order.converter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.hans.order.dataobject.OrderDetail;
import com.hans.order.dto.OrderDTO;
import com.hans.order.enums.ResultEnum;
import com.hans.order.exception.OrderException;
import com.hans.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hans
 */
@Slf4j
public class OrderForm2OrderDTOConvert {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        Gson gson = new Gson();

        try{
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("josn convert failed. string={}", orderForm.getItems());

            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
