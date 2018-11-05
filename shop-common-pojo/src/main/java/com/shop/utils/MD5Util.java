package com.shop.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

/**
 * Created By Lizhengyuan on 18-10-30
 */
public class MD5Util {

    public static String getMD5Res(String origin) {
        return StringUtils.isEmpty(origin) ? null : DigestUtils.md5DigestAsHex(origin.getBytes());
    }
}
