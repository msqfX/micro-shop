package com.shop.item.service;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created By Lizhengyuan on 18-11-12
 */
@FeignClient(value = "shop-service-item")
public interface ItemService {

    @RequestLine("GET /getItemById?id={id}")
   // @RequestMapping(value = "/getItemById/?id={id}", method = RequestMethod.GET)
    Object getItemById(@Param("id") String id);
}
