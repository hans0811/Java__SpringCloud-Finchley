package com.hans.order.controller;

import com.hans.order.VO.ResultVO;
import com.hans.order.converter.OrderForm2OrderDTOConvert;
import com.hans.order.dto.OrderDTO;
import com.hans.order.enums.ResultEnum;
import com.hans.order.exception.OrderException;
import com.hans.order.form.OrderForm;
import com.hans.order.service.OrderService;
import com.hans.order.utils.ResultVOUtil;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hans
 */

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. validate parms
     * 2. search item information
     * 3. total price
     * 4. change stock
     * 5. order
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("create param not correct, orderForm={} ", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        // oderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConvert.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVOUtil.success(map);
    }
}
