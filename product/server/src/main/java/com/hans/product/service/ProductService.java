package com.hans.product.service;

import com.hans.product.common.DecreaseStockInput;
import com.hans.product.common.ProductInfoOutput;
import com.hans.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @author hans
 */
public interface ProductService {

    /**
     * seach all items list
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * search a item list
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * deduction of stock
     * @param decreaseStockInput
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInput);
}
