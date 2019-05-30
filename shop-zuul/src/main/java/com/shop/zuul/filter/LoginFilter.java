package com.shop.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 用户登陆过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器类型-前置过滤器
     *
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器执行顺序-越小越先执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     * 过滤器是否生效
     *
     * @return
     */
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
        System.out.println("拦截了");

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getHeader("token");
        /*if (StringUtils.isEmpty(token)) {

            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

        }*/

        return null;
    }
}
