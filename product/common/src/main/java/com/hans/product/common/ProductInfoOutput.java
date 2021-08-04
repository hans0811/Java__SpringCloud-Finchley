package com.hans.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hans
 */
@Data
public class ProductInfoOutput {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;
}
