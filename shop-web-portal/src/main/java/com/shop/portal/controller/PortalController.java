package com.shop.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By Lizhengyuan on 18-11-7
 */
@Controller
public class PortalController {

    @RequestMapping("/{page}")
    public String getPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/hellobtl")
    public String helloBeetl(Model model){
        System.out.println("xxx");
        model.addAttribute("username","lizy");
        return "hello";
    }



}
