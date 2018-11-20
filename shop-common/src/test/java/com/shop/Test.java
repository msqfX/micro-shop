package com.shop;

import com.shop.utils.JsonUtils;
import com.shop.utils.MD5Util;

/**
 * Created By Lizhengyuan on 18-10-24
 */
public class Test {

    @org.junit.Test
    public void test(){
        System.out.println(JsonUtils.asMap("code",1,"mess","success"));
    }

    @org.junit.Test
    public void test2(){
        System.out.println(MD5Util.getMD5Res("123456"));
    }
}
