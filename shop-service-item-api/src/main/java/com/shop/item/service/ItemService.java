package com.shop.item.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By Lizhengyuan on 18-11-12
 */
@FeignClient(value = "shop-service-item")
public interface ItemService {

    //@RequestLine("GET /getItemById")
    @RequestMapping(value = "/getItemById", method = RequestMethod.GET)
    Object getItemById(@RequestParam(value = "id") String id);

    @RequestMapping(value = "/getItemDescById", method = RequestMethod.GET)
    Object getItemDescById(@RequestParam(value = "id") String id);
}
