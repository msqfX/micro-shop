package com.shop.item.controller;

import com.shop.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By Lizhengyuan on 18-11-12
 */
@Controller
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
        Object itemDesc = itemService.getItemDescById(id);
        model.addAttribute("item", item);
        model.addAttribute("itemDesc", itemDesc);
        return "item";
    }

    /**
     * 根据商品分类查询商品
     * @param itemCatId
     * @param model  getItemByCat?itemCatId
     * @return
     */
    @RequestMapping("getItemByCat")
    public Object getItemByCat(@RequestParam String itemCatId, Model model){
        Object itemList = itemService.getItemByCat(itemCatId);
        model.addAttribute("itemList", itemList);
        return "item";
    }
}
