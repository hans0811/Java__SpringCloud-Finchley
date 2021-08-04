package com.hans.order.enums;

import lombok.Getter;

/**
 * @author hans
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "wiat"),
    SUCCESS(1, "Paid"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
