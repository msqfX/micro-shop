package com.shop.utils;

import java.sql.Timestamp;

/**
 * Created By Lizhengyuan on 18-11-6
 */
public class DateUtil {

    /**
     * 获得当前的日期毫秒
     *
     * @return
     */
    public static long nowTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获得当前的时间戳
     *
     * @return
     */
    public static Timestamp nowTimeStamp() {
        return new Timestamp(nowTimeMillis());
    }



}
