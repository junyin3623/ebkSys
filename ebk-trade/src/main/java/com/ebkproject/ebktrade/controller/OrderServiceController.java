package com.ebkproject.ebktrade.controller;

import com.ebkproject.ebktrade.feign.AuthFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class OrderServiceController {

    @Autowired
    AuthFeignService authFeignService;


    /**
     * 根据订单 id 查找商品信息 * @param id 订单 id * @return 商品服务返回的数据
     */
    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable("id") String id) {


        return authFeignService.getProduct(id);
//        return restTemplate.getForObject("http://ebkauth/product/" + id, String.class);
    }
}
