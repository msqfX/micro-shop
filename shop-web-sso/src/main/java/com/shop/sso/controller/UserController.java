package com.shop.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created By Lizhengyuan on 18-11-7
 */
@Controller
public class UserController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }




}
