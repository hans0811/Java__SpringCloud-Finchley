package com.hans.product.repository;

import com.hans.product.dataobject.ProductCategory;
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
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assertions.assertTrue(list.size() > 0);
    }
}