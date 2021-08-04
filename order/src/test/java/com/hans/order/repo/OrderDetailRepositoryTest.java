package com.hans.order.repo;

import com.hans.order.OrderApplicationTests;
import com.hans.order.dataobject.OrderDetail;
import com.hans.order.dataobject.OrderMaster;
import com.hans.order.enums.OrderStatusEnum;
import com.hans.order.enums.PayStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hans
 */
@Component
class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12367");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assertions.assertTrue(result != null);
    }

}