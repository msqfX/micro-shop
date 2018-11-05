package com.shop.controller;

import com.shop.pojo.Admin;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created By Lizhengyuan on 18-10-30
 * 管理员接口
 */
@Controller
@RequestMapping("admin")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public Object login(@RequestParam String userName, @RequestParam String passWord , HttpSession httpSession){
        Admin user = userService.login(userName, passWord);
        if(!Objects.isNull(user)){
            httpSession.setAttribute("userInfo",user);
            return getResMap(1,"登录成功");
        }else {
            return getResMap(0, "登录失败");
        }
    }

    @RequestMapping("logout")
    public Object logout(HttpSession httpSession){
        httpSession.removeAttribute("userInfo");
        return "login";
    }

}
