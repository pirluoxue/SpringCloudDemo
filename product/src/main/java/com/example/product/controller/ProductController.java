package com.example.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String testProduct(){
        return "Hello Spring Cloud 中文测试";
    }


}
