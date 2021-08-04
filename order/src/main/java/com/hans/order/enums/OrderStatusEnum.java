package com.hans.order.enums;

import lombok.Getter;

/**
 * @author hans
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "NEW ORDER"),
    FINISHED(1, "FINISH"),
    CANCEL(2, "CANCEL"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
