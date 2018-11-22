package com.shop.utils;

/**
 * Created By Lizhengyuan on 18-11-22
 */
public interface SessionProvider {

    void setUserSession(String sessionId, String value);

    String getUserSession(String sessionId);

}
