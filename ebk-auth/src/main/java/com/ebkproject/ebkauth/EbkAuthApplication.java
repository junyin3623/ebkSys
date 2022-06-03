package com.ebkproject.ebkauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableRedisHttpSession
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.ebkproject.ebkauth")
@MapperScan("com.ebkproject.ebkauth.dao")
public class EbkAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbkAuthApplication.class, args);
    }

}
