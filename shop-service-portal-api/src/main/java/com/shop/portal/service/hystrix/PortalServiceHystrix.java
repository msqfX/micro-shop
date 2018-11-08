package com.shop.portal.service.hystrix;

import com.shop.portal.service.PortalService;
import org.springframework.stereotype.Component;

/**
 * Created By Lizhengyuan on 18-11-8
 */
@Component
public class PortalServiceHystrix implements PortalService {


    @Override
    public Object getSortMenuList() {
        //熔断

        return null;
    }
}
