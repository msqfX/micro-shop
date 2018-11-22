package com.shop.utils.impl;

import com.shop.utils.JedisClient;
import com.shop.utils.SessionProvider;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * Created By Lizhengyuan on 18-11-22
 */
public class SessionProviderImpl implements SessionProvider {

    private Integer exp;

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @Autowired
    private JedisClient jedisClient;

    @Override
    public void setAttribute(String key, String value) {
        jedisClient.set(key, value);
        jedisClient.expire(key, 60*exp);
    }

    @Override
    public String getAttribute(String key) {
        String value = jedisClient.get(key);
        if(!StringUtils.isEmpty(value)){
            jedisClient.expire(key, 60*exp);
            return value;
        }
        return null;
    }

    public void logout(String key){
        jedisClient.del(key);
    }
}
