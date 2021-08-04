package com.hans.product.service.Impl;

import com.hans.product.common.DecreaseStockInput;
import com.hans.product.common.ProductInfoOutput;
import com.hans.product.dataobject.ProductInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hans
 */
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list =  productService.findUpAll();
        Assertions.assertTrue(list.size() > 0 );
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfoOutput> list =  productService.findList(Arrays.asList("157875196366160022",
                "157875227953464068"));
        Assertions.assertTrue(list.size() > 0 );
    }

    @Test
    public void decreaseStock() throws Exception {
        DecreaseStockInput decreaseStock = new DecreaseStockInput("157875196366160022", 2);
        productService.decreaseStock(Arrays.asList(decreaseStock));

    }

}