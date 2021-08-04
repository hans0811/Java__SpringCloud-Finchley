package com.hans.product.service;

import com.hans.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @author hans
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
