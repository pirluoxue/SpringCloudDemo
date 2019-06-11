package com.example.zuul.bean;

import com.example.zuul.bean.filter.PostZuulFilter;
import com.example.zuul.bean.filter.PreSecondZuulFilter;
import com.example.zuul.bean.filter.PreZuulFilter;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Classname ZuulFilter
 * @Description 路由过滤bean
 * @Date 2019-06-11
 * @Created by chen_bq
 */
@Component
public class ZuulFilterBean {

    @Bean
    public PreZuulFilter preZuulFilter() {
        return new PreZuulFilter();
    }
    @Bean
    public PreSecondZuulFilter preSecondZuulFilter() {
        return new PreSecondZuulFilter();
    }
    @Bean
    public PostZuulFilter postZuulFilter(){
        return new PostZuulFilter();
    }

}
