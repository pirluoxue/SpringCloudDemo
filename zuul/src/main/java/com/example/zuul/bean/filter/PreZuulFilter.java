package com.example.zuul.bean.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sun.security.provider.certpath.OCSPResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname PreZuulFilter
 * @Description pre级的过滤
 * @Date 2019-06-11
 * @Created by chen_bq
 */
public class PreZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获得从Zuul中获得请求的上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取请求
        HttpServletRequest request = ctx.getRequest();
        System.out.println("PreZuulFilter---------> > >  request method " + request.getMethod() + "  request uri " + request.getRequestURI());
        /*可供的一些常用操作*/
//        ctx.setSendZuulResponse(true); //对请求进行路由，false则不进行路由
//        ctx.setResponseStatusCode(HttpStatus.OK.value());//返回200
//        ctx.setResponseBody("返回内容 123");//成功转发如果直接传参，而转发接口也是传参，则只会返回这里的responseBody
//        //并且，允许转发，则转发结果将会拥有响应的编码，即若setResponseBody后，返回的就是"返回内容 123"。若不允许转发，则返回就变成了”？？？ 123“
//        ctx.set("isSuccess", true);
        /*可供的一些常用操作*/
//        System.out.println("request ContentType-----------> > >  " + request.getContentType());
//        System.out.println("response ContentType-----------> > >  " + ctx.getResponse().getContentType());
//        System.out.println("PreZuulFilter 进行路由");
        return null;
    }
}
