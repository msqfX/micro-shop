package com.shop;

import com.shop.utils.JsonUtils;

/**
 * Created By Lizhengyuan on 18-10-24
 */
public class Test {

    @org.junit.Test
    public void test(){
        System.out.println(JsonUtils.asMap("code",1,"mess","success"));
    }
}
