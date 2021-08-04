package com.hans.order.controller;

import com.hans.order.client.ProductClient;
import com.hans.order.dataobject.ProductInfo;
import com.hans.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author hans
 */
@RestController
@Slf4j
public class ClientController {
    // second way
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    // Third way use loadbalance
//    @Autowired
//    private RestTemplate restTemplate;

    // use FeignClient client
    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // first way
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);


        // second way
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/msg");
//        String response = restTemplate.getForObject(url, String.class);

        // Third way ( use @LoadBalanced)
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);

        String response = productClient.productMsg();
        log.info("response={}", response);

        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfoList =  productClient.ListForOrder(Arrays.asList("164103465734242707"));
        log.info("response={}", productInfoList);
        return "success";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707", 3)));
        return "Decrease";
    }
}
