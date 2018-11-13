package com.shop.item;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created By Lizhengyuan on 18-11-12
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.shop.mapper")
@EnableCircuitBreaker//对hystrixR熔断机制的支持
@EnableHystrix
public class ShopServiceItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceItemApplication.class, args);
    }

}
