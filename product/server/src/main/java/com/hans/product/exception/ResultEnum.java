package com.hans.product.exception;

import lombok.Getter;

/**
 * @author hans
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "ITEM NOT EXIST"),
    PRODUCT_STOCK_ERROR(2, "OUT OF STOCK"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
