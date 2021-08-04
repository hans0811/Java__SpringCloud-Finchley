package com.hans.product.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author hans
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "on sale"),
    DOWN(1, "discontinued"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
