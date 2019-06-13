package com.example.product.controller;

import com.example.product.ProductApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname ProductController
 * @Description TODO
 * @Date 2019-06-04
 * @Created by chen_bq
 */
@Controller
public class ProductController {

    @RequestMapping("product")
    @ResponseBody
    public String product(){
        return "Hello Spring Cloud 中文测试";
    }

    @RequestMapping("paramProduct")
    @ResponseBody
    public String paramProduct(@RequestParam String param, HttpServletRequest request){
        return "get address：" + request.getLocalAddr() + ":" + request.getLocalPort() + param;
    }

}
