package com.hans.order.service;

import com.hans.order.dto.OrderDTO;

/**
 * @author hans
 */
public interface OrderService {
    /**
     * create Order
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
