package com.example.gateway.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


/**
 * @Classname HystrixController
 * @Description TODO
 * @Date 2019-06-13
 * @Created by chen_bq
 */
@Controller
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("gatewayFallBack")
    @ResponseBody
    public String subjectivityHystrix(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>gateway forward gatewayFallBack</h1>");
        stringBuilder.append("<h1>主动触发hystrix 成功</h1>");
        return stringBuilder.toString();
    }

    @RequestMapping("forwardOtherService")
    @ResponseBody
    public String forwardOtherService(){
        String url = "http://localhost:9010/product";
        return restTemplate.getForObject(url, String.class);
    }



}
