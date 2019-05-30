package com.shop.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ShopZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopZuulApplication.class, args);
    }

}
