package com.shop;

import com.shop.utils.MD5Util;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created By Lizhengyuan on 18-10-30
 */
@SpringBootTest
public class CommonTest {

    @Test
    public void test(){
        System.out.println(MD5Util.getMD5Res("admin123"));

    }


}
