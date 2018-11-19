package com.shop.portal.service.hystrix;

import com.shop.common.RespResult;
import com.shop.portal.service.PortalService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created By Lizhengyuan on 18-11-8
 */
@Component
public class PortalServiceHystrix/* implements FallbackFactory<PortalService>*/ {

/*
    @Override
    public PortalService create(Throwable cause) {
        return new PortalService() {
            @Override
            public Object getSortMenuList() {
                return RespResult.buildErrorJson("获取首页列表异常");
            }
        };
    }*/
}
