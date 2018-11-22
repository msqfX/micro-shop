package com.shop.sso;

import com.shop.utils.JedisClient;
import com.shop.utils.impl.JedisClientSingle;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 李正元
 * @create 2018-11-06 21:33
 * @desc
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.shop.mapper")
@EnableCircuitBreaker//对hystrixR熔断机制的支持
@EnableHystrix
public class ShopServiceSSOApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceSSOApplication.class, args);
    }

    @Bean
    public JedisClient jedisClient(){
        return new JedisClientSingle();
    }

}
