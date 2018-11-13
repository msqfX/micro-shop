package com.shop.portal.controller;

import com.shop.portal.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created By Lizhengyuan on 18-11-7
 */
@Controller
public class PortalController {

    @Autowired
    private PortalService portalService;

    /*@RequestMapping("/{page}")
    public String getPage(@PathVariable String page){
        return page;
    }*/

    @RequestMapping("/hellobtl")
    public String helloBeetl(Model model){
        System.out.println("xxx");
        model.addAttribute("username","lizy");
        return "hello";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("sortMenuList", portalService.getSortMenuList());
        return "index";
    }



}
