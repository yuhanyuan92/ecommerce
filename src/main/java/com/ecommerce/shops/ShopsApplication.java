package com.ecommerce.shops;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.ecommerce.shops.mapper")
public class ShopsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopsApplication.class, args);
    }

}

