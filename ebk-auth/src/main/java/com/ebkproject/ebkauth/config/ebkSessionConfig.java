package com.ebkproject.ebkauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class ebkSessionConfig {

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        //session作用域
//        cookieSerializer.setDomainName("ebkbank.com");//设置默认，或者说放大主域
        cookieSerializer.setCookieName("ebkBankSESSION");//设置cookie名字
        return cookieSerializer;
    }

    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        //序列化机制
        return new GenericJackson2JsonRedisSerializer();
    }
}

