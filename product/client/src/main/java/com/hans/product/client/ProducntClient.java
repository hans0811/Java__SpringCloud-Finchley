package com.hans.product.client;

import com.hans.product.common.DecreaseStockInput;
import com.hans.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author hans
 */
@FeignClient(name="product")
public interface ProducntClient {
    /**
     * get item list(for order service)
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    List<ProductInfoOutput> ListForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInput);

}
