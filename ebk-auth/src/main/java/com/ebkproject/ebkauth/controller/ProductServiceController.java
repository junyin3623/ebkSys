package com.ebkproject.ebkauth.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 订单服务的接口 *
 */
@RestController
public class ProductServiceController {
    /**
     * 订单服务 * @param name 商品名称 * @return 测试返回商品名
     */
    @GetMapping("/product/{name}")
    public String getProduct(@PathVariable("name") String name) {
        System.out.println("商品服务被调用了");
        return "order" + name;
    }
}
