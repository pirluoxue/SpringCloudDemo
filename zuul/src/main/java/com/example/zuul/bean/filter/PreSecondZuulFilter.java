package com.example.zuul.bean.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname PreZuulFilter
 * @Description pre级的过滤
 * @Date 2019-06-11
 * @Created by chen_bq
 */
public class PreSecondZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获得request上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取请求
        HttpServletRequest request = ctx.getRequest();
        System.out.println("PreSecondZuulFilter---------> > >  request method " + request.getMethod() + "  request uri " + request.getRequestURI());
        /*可供的一些常用操作*/
//        ctx.setSendZuulResponse(false); //对请求进行路由，false则不进行路由
//        //若不允许，则必须加上编码类型，否则将会乱码
//        ctx.getResponse().setContentType("text/html;charset=UTF-8");
//        ctx.setResponseStatusCode(HttpStatus.OK.value());//返回200
//        ctx.setResponseBody("返回内容 456");
//        ctx.set("isSuccess", false);
        /*可供的一些常用操作*/
        System.out.println("PreSecondZuulFilter 不进行路由");
        return null;
    }
}
