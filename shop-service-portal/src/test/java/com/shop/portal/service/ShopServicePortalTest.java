package com.shop.portal.service;

import com.shop.utils.JedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * Created By Lizhengyuan on 18-11-8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServicePortalTest {

    @Autowired
    private PortalService portalService;

    @Autowired
    private JedisClient jedisClient;


    @Test
    public void testMenuList(){
        Object sortMenuList = portalService.getSortMenuList();
        System.out.println(sortMenuList);

    }

    @Test
    public void testJedis(){
        Jedis jedis = new Jedis();
        jedis.set("lizy", "lizy");
        String str = jedis.get("lizy");
        System.out.println(str);
        System.out.println(".............."+jedisClient.get("lizy"));
    }

}
