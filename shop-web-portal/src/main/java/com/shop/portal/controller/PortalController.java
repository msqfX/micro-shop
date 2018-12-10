package com.shop.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.portal.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        //String userName = CookieUtil.getCookieValue(request, Constant.TOKEN_LOGIN);
        //model.addAttribute("userName", userName);
        model.addAttribute("sortMenuList", portalService.getSortMenuList());
        return "index";
    }

    @RequestMapping("getSortListJson")
    @ResponseBody
    public Object getSortListJson(){
        Object sortMenuList = portalService.getSortMenuList();
        return JSONObject.toJSON(sortMenuList);
    }
}
