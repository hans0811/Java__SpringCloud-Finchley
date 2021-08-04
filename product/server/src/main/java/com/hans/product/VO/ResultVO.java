package com.hans.product.VO;

import lombok.Data;

/**
 * @author hans
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
