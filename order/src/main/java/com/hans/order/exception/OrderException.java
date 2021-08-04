package com.hans.order.exception;

import com.hans.order.enums.ResultEnum;

/**
 * @author hans
 */
public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
