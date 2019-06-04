package com.zf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 张帆
 * @create: 2019-06-03 16:16
 * @Description: 自定义过滤器
 **/
public class AccessFilter extends ZuulFilter {

    private static Logger log  = LoggerFactory.getLogger(AccessFilter.class);

    // 过滤器的类型
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 判断该过滤器是否执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑
    /**  http://localhost:5555/api-a/hello?accessToken=token
     *  不加accessToken 返回 401 状态码
     * **/
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");

        if(accessToken == null){
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
