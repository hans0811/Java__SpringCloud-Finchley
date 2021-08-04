package com.hans.product.controller;

import com.hans.product.VO.ProductInfoVo;
import com.hans.product.VO.ProductVO;
import com.hans.product.VO.ResultVO;
import com.hans.product.common.DecreaseStockInput;
import com.hans.product.common.ProductInfoOutput;
import com.hans.product.dataobject.ProductCategory;
import com.hans.product.dataobject.ProductInfo;
import com.hans.product.service.Impl.CategoryServiceImpl;
import com.hans.product.service.Impl.ProductServiceImpl;
import com.hans.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hans
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl CategoryServiceImpl;

    /**
     * 1. query items
     * 2. get type list
     * 3. query catalog
     * 4. data
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        // get all items
        List<ProductInfo> productInfoList = productService.findUpAll();

        // get type list
        List<Integer> categoryTypeList = productInfoList.stream()
                                                        .map(ProductInfo::getCategoryType)
                                                        .collect(Collectors.toList());

        // query category from db
        List<ProductCategory> categoryList = CategoryServiceImpl.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for(ProductInfo productInfo: productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVO.setProductInfoVoList(productInfoVoList);
            productVOList.add(productVO);
        }


        return ResultVOUtil.success(productVOList);
    }

    /**
     * get item list(for order service)
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> ListForOrder(@RequestBody List<String> productIdList){
       return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInput) {
        productService.decreaseStock(decreaseStockInput);
    }
}
