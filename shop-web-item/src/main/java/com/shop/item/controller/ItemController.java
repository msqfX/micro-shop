package com.shop.item.controller;

import com.shop.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "getItemById", method = RequestMethod.GET)
    public Object getItemById(@RequestParam String id){
        Object itemById = itemService.getItemById(id);
        return "item";

    }

}
