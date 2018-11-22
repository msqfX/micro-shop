package com.shop.utils;

import com.shop.common.Constant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created By Lizhengyuan on 18-11-22
 */
public class RequestUtil {

    public static String getSessionId(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length < 1){
            for (Cookie cookie : cookies) {
                if(Constant.TOKEN_LOGIN.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        String sessionId = UUID.randomUUID().toString().replace("-","");
        Cookie cookie = new Cookie(Constant.TOKEN_LOGIN, sessionId);
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        return sessionId;
    }
}
