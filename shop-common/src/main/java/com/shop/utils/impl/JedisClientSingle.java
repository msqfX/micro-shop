package com.shop.utils.impl;

import com.shop.utils.JedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * Created By Lizhengyuan on 18-11-6
 */
public class JedisClientSingle implements JedisClient {

    @Autowired
    private JedisPool jedisPool;

    @Value("${redis.password}")
    private String password;

    private Jedis getResource() {
        Jedis resource = jedisPool.getResource();
        if (StringUtils.isBlank(password)) {
            return resource;
        } else {
            resource.auth(password);
            return resource;
        }
    }

    @Override
    public String get(String key) {
        Jedis jedis = getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = getResource();
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = getResource();
        String value = jedis.hget(hkey, key);
        jedis.close();
        return value;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = getResource();
        Long result = jedis.hset(hkey, key, value);
        jedis.close();
        return result;
    }

    @Override
    public long incr(String key) {
        Jedis jedis = getResource();
        Long value = jedis.incr(key);
        jedis.close();
        return value;
    }

    @Override
    public long expire(String key, Integer second) {
        Jedis jedis = getResource();
        Long result = jedis.expire(key, second);
        jedis.close();
        return result;
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = getResource();
        Long aLong = jedis.ttl(key);
        jedis.close();
        return aLong;
    }

    @Override
    public long del(String key) {
        Jedis jedis = getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    @Override
    public long hdel(String hkey, String key) {
        Jedis jedis = getResource();
        Long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }
}
