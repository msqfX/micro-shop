package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.awt.print.Paper;
import java.util.Objects;

/**
 * Created By Lizhengyuan on 18-10-26
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public Object test(HttpSession httpSession, Model model){
        Object userInfo = httpSession.getAttribute("userInfo");
        if(!Objects.isNull(userInfo)){
            model.addAttribute("sfesf",123);
            return "index";
        }else return "login";
    }

    @RequestMapping("/home")
    public Object home(){
        return "home";
    }

    @RequestMapping("login")
    public Object login(){
        return "login";
    }

    @RequestMapping("listProduct")
    public Object listProduct(){
        return "Products_List";
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }
}
