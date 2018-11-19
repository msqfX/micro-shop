package com.shop.item.controller;

import com.shop.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By Lizhengyuan on 18-11-12
 */
@Controller
@RequestMapping("/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 商品详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "getItemById", method = RequestMethod.GET)
    public Object getItemById(@RequestParam String id, Model model){
        Object item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item";
    }

}
