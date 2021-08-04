package com.hans.product.service.Impl;

import com.hans.product.dataobject.ProductCategory;
import com.hans.product.repository.ProductCategoryRepository;
import com.hans.product.service.CategoryService;
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
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    void findByCategoryTypeIn() throws Exception{
        List<ProductCategory>  list = categoryServiceImpl.findByCategoryTypeIn(Arrays.asList(11,22));
        Assertions.assertTrue( list.size() > 0 );
    }
}