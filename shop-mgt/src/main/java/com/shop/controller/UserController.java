package com.shop.controller;

import com.shop.pojo.Admin;
import com.shop.portal.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "API - AdminController", description = "管理员 Controller")
@Controller
@RequestMapping("admin")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;


    @ApiOperation(value = "管理员登录",notes = "需要传递一个uuid作为用户本次登录的唯一表示")
    @ApiImplicitParam(name = "userName,password",value = "每个 userName,password 对应一次用户登录",required = true,dataType = "String")
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
