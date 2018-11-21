package com.shop.portal.controller;

import com.shop.common.Constant;
import com.shop.portal.service.PortalService;
import com.shop.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Lizhengyuan on 18-11-7
 */
@Controller
public class PortalController {

    @Autowired
    private PortalService portalService;

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

    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request){
        String userName = CookieUtil.getCookieValue(request, Constant.TOKEN_LOGIN);
        model.addAttribute("userName", userName);
        model.addAttribute("sortMenuList", portalService.getSortMenuList());
        return "index";
    }

}
