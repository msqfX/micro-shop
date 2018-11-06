package com.shop.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Created By Lizhengyuan on 18-11-06
 */
public class JsonUtils {

    public static <T> Map<String, T> asMap(Object... args) {
        int len  = args.length;
        if(len % 2 != 0)
            throw new IllegalArgumentException("Map size is illeagal "+len);
        Map<String, T> map = new HashMap<>();
        for(int i = 0; i < len-1; i += 2){
            map.put(String.valueOf(args[i]),(T)args[i+1]);
        }
        return map;
    }

    public static Object toJson(Object obj){
        if(Objects.isNull(obj)){
            return null;
        }else {
            return JSON.toJSON(obj);
        }
    }

    public static <T> T convertJSONToObject(String data, Class<T> Clzss){
        try {
            T t = JSON.parseObject(data, Clzss);
            return t;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static <T> T convertJSONToObject(JSONObject jsonObject, Class<T> clzss){
        try {
            T t = JSONObject.toJavaObject(jsonObject, clzss);
            return t;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> convertJSONToArray(String data, Class<T> clzss){
        try {
            List<T> list = JSON.parseArray(data, clzss);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> convertJSONToArray(List<JSONObject> data, Class<T> clzss) {
        try {
            List<T> t = new ArrayList<T>();
            for (JSONObject jsonObject : data) {
                t.add(convertJSONToObject(jsonObject, clzss));
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
