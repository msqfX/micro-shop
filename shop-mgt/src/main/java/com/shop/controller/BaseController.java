package com.shop.controller;

import com.shop.common.ConstantResp;
import com.shop.utils.JsonUtils;

/**
 * Created By Lizhengyuan on 18-10-30
 */
public class BaseController {

    public Object builderSuccessJson(Object data){
        return buildJson(ConstantResp.Res_Success, data);
    }

    public Object builderErrorJson(){
        return buildJson(ConstantResp.Res_Error, "");
    }

    public Object builderErrorJson(String messsage){
        return buildJson(ConstantResp.Res_Error, messsage);
    }

    public Object buildJson(int code, Object data) {
        if (data == null) {
            return JsonUtils.asMap("code", code, "resp", "");
        } else {
            return JsonUtils.asMap("code", code, "resp", data);
        }
    }

    public Object getResMap(int code, String message){
        return JsonUtils.asMap("code", code, "msg", message);
    }


}
