package com.hans.product.repository;

import com.hans.product.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hans
 */
@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assertions.assertTrue( list.size() > 0);
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> list = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022",
                "157875227953464068"));
        Assertions.assertTrue( list.size() > 0);
    }

}