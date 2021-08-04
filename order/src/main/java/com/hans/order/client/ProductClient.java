package com.hans.order.client;

import com.hans.order.dataobject.ProductInfo;
import com.hans.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author hans
 */
@FeignClient(name="product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> ListForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
