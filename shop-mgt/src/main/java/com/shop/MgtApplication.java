package com.shop;

import com.github.pagehelper.PageHelper;
import com.shop.utils.JedisClient;
import com.shop.utils.impl.JedisClientSingle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

/**
 * Created By Lizhengyuan on 18-10-24
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.shop.*")
public class MgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgtApplication.class, args);
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","postgresql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    @Bean
    public JedisClient jedisClient() {
        return new JedisClientSingle();
    }

}
