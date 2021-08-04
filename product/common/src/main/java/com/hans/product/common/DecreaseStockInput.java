package com.hans.product.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hans
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecreaseStockInput {
    /**
     * item ID
     */
    private String productId;

    /**
     * Item quantity
     */
    private Integer productQuantity;
}
