package com.shop.portal.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created By Lizhengyuan on 18-11-8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServicePortalTest {

    @Autowired
    private PortalService portalService;

    @Test
    public void testMenuList(){
        Object sortMenuList = portalService.getSortMenuList();


    }

}
