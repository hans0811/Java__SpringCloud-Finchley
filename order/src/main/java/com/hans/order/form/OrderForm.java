package com.hans.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author hans
 */
@Data
public class OrderForm {
    /**
     * Buyer name
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * phone
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * buyer address
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * wx
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * shopping cart
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
