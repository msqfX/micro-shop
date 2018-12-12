package com.shop.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.portal.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${user_path.login}")
    private String loginPath;

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
        model.addAttribute("loginPath", loginPath);
        return "index";
    }

    /**
     * 获取分类列表数据
     * @return
     */
    @RequestMapping("getSortListJson")
    @ResponseBody
    public Object getSortListJson(){
        Object sortMenuList = portalService.getSortMenuList();
        return JSONObject.toJSON(sortMenuList);
    }
}
