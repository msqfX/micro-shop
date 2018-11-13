package com.shop.portal.service;

import com.shop.portal.service.hystrix.PortalServiceHystrix;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created By Lizhengyuan on 18-11-8
 */
@FeignClient(value = "shop-service-portal",fallbackFactory = PortalServiceHystrix.class)
public interface PortalService {

    //@RequestMapping(value = "/getSortMenuList",method = RequestMethod.GET)
    @RequestLine("GET /getSortMenuList")
    Object getSortMenuList();

}
