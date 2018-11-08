package com.shop.portal;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created By Lizhengyuan on 18-11-8
 */
@EnableHystrix@Configuration
@EnableApolloConfig
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.shop.mapper")
public class ShopServicePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServicePortalApplication.class, args);
    }

}
