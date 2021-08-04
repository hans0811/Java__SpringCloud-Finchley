package com.hans.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hans
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    /**
     * item ID
     */
    private String productId;

    /**
     * Item quantity
     */
    private Integer productQuantity;

}
