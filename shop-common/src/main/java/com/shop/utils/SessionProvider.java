package com.shop.utils;

/**
 * Created By Lizhengyuan on 18-11-22
 */
public interface SessionProvider {

    void setAttribute(String key, String value);

    String getAttribute(String key);

}
