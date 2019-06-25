package com.example.zuul.bean.filter;

import com.example.zuul.util.HttpUtils;
import com.example.zuul.util.ZuulUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @Classname PostZuulFilter
 * @Description 这种过滤器在路由到微服务以后执行。
 * 这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
 * @Date 2019-06-11
 * @Created by chen_bq
 */
public class PostZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
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
        //获得request上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //从response中获取返回数据流
        System.out.println(ZuulUtils.getResponseDataByRequestContext(ctx));
        //再次获取，测试工具类是否能够重复使用数据流
        System.out.println(ZuulUtils.getResponseDataByRequestContext(ctx));
//        InputStream stream = ctx.getResponseDataStream();
//        try {
//            //读取返回数据流，注意的是，读取的数据流能且只能读取一次，读取之后，返回流将会清空
//            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
//            System.out.println(body);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //获取请求
//        HttpServletResponse response = ctx.getResponse();
//        System.out.println("PostZuulFilter-----------> > >  返回信息  ");
//        System.out.println("post ResponseBody-----------> > >  " + ctx.getResponseBody());
//        System.out.println("post request ContentType-----------> > >  " + ctx.getRequest().getContentType());
//        System.out.println("post response ContentType-----------> > >  " + response.getContentType());
        //若返回数据流存在信息，并且ctx也设置responseBody，则客户端仅能接受到ctx中的responseBody
//        ctx.setResponseBody("测试post返回");
        return null;
    }
}
