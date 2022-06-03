package com.ebkproject.ebktrade.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ebkauth")
public interface AuthFeignService {


    @GetMapping("/product/{name}")
    public String getProduct(@PathVariable("name") String name);
}
