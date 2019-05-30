package com.shop.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 网关限流
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    //每秒产生1000个令牌
    private static RateLimiter rateLimiter = RateLimiter.create(1000);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        /*System.out.println(request.getRequestURI());  /api_gateway/getSortMenuList
        System.out.println(request.getRequestURL()); http://localhost:9000/api_gateway/getSortMenuList  */

        //访问控制列表（Access Control List，ACL）

        if ("/api_gateway/getSortMenuList".equals(request.getRequestURI())) {
            return true;
        }


        return false;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        if(!rateLimiter.tryAcquire()){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }

        return null;
    }
}
