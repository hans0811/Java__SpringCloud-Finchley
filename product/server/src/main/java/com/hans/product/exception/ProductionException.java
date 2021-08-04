package com.hans.product.exception;

/**
 * @author hans
 */
public class ProductionException extends RuntimeException{

    private Integer code;

    public ProductionException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public ProductionException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
