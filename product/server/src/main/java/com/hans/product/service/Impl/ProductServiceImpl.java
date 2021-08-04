package com.hans.product.service.Impl;

import com.hans.product.common.DecreaseStockInput;
import com.hans.product.common.ProductInfoOutput;
import com.hans.product.dataobject.ProductInfo;
import com.hans.product.enums.ProductStatusEnum;
import com.hans.product.exception.ProductionException;
import com.hans.product.exception.ResultEnum;
import com.hans.product.repository.ProductInfoRepository;
import com.hans.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author hans
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInput) {
        for (DecreaseStockInput decreaseStock: decreaseStockInput) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStock.getProductId());
            // Whether item exist
            if(!productInfoOptional.isPresent()){
                throw new ProductionException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            // Whether stock is enough or not
            Integer result = productInfo.getProductStock() - decreaseStock.getProductQuantity();
            if( result < 0 ){
                throw new ProductionException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
