package com.shop.sso.service;

import com.shop.utils.JedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created By Lizhengyuan on 18-11-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceSSoTest {

    @Autowired
    private JedisClient jedisClient;

    @Test
    public void test (){
        System.out.println(jedisClient.get("lizy"));
    }


}
