package com.hans.order.enums;

import lombok.Getter;

/**
 * @author hans
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "param error"),
    CART_EMPTY(2, "cart is empty")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
