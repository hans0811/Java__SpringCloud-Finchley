package com.hans.order.repo;

import com.hans.order.OrderApplication;
import com.hans.order.OrderApplicationTests;
import com.hans.order.dataobject.OrderMaster;
import com.hans.order.enums.OrderStatusEnum;
import com.hans.order.enums.PayStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hans
 */
@Component
class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345675");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assertions.assertTrue(result != null);
    }

}