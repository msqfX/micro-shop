package com.shop.sso.service;

import com.shop.common.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By Lizhengyuan on 18-11-20
 */
@FeignClient(value = "shop-service-sso")
public interface UserService {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    RespResult login(@RequestParam("sessionId") String sessionId, @RequestParam(value = "userName") String userName,
                     @RequestParam(value = "passWord") String passWord);

}
