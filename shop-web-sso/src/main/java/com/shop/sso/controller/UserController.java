package com.shop.sso.controller;

import com.shop.common.Constant;
import com.shop.common.RespResult;
import com.shop.pojo.User;
import com.shop.sso.service.UserService;
import com.shop.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Lizhengyuan on 18-11-7
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${portal_path}")
    public String indexPath;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public @ResponseBody Object login(User user,
                                      HttpServletResponse response, HttpServletRequest request){
        RespResult result = userService.login(user.getUsername(), user.getPassword());
        Map<String, Object> resultMap = new HashMap<>();
        if(result.getStatus() == Constant.SUCCESS_REQUEST){
            CookieUtil.setCookie(request, response, Constant.TOKEN_LOGIN, user.getUsername());
            resultMap.put("returnUrl", indexPath);
        }
        return RespResult.build(result.getStatus(), result.getMsg(), resultMap);
    }

}
