package com.ecommerce.shops.filter;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @program: qlm-zxhy
 * @description: 内存缓存（多台服务器下考虑用redis）
 * @author: hanyuan.yu
 * @create: 2019/1/30 14:10
 * @Version 1.0
 **/
@Configuration
public class UrlCache {
    @Bean
    public Cache<String, Integer> getCache() {
        return CacheBuilder.newBuilder().expireAfterWrite(2L, TimeUnit.SECONDS).build();// 缓存有效期为2秒
    }
}