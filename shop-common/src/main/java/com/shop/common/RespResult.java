package com.shop.common;


import com.shop.utils.JsonUtils;

/**
 * Created By Lizhengyuan on 18-11-6
 */
public class RespResult {

    private final static int DEFAULT_SUCCESS_CODE = 1;
    private final static String DEFAULT_SUCCESS_MSG = "SUCCESS";

    private final static int DEFAULT_ERROR_CODE = 0;
    private final static String DEFAULT_ERROR_MSG = "ERROR";

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;


    RespResult() {

    }

    RespResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    RespResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static RespResult build(Integer status, String msg, Object data) {
        return new RespResult(status, msg, data);
    }

    public static RespResult build(Integer status, String msg) {
        return new RespResult(status, msg);
    }

    public static Object buildSuccessJson(Object data) {
        return buildJson(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, data);
    }

    public static Object buildErrorJson(Object data) {
        return buildJson(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG, data);
    }

    private static Object buildJson(Integer code, String msg, Object data) {
        return JsonUtils.asMap("code", code, "msg", msg, "data", data);
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
