package com.example.client.controller;

import com.example.client.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

/**
 * @Classname FeignController
 * @Description TODO
 * @Date 2019-06-04
 * @Created by chen_bq
 */
@Controller
public class TestFeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "clientFeign",method = RequestMethod.GET)
    @ResponseBody
    public String testFeign() {
        return feignService.product();
    }

    @RequestMapping(value = "paramFeign",method = RequestMethod.GET)
    @ResponseBody
    public String testParam(@RequestParam String param) {
        return feignService.paramProductByFeign(param);
    }

    @RequestMapping("subjectivityHystrix")
    @ResponseBody
    public String subjectivityHystrix(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>gateway forward subjectivityHystrix</h1>");
        stringBuilder.append("<h1>主动触发hystrix 成功</h1>");
        return stringBuilder.toString();
    }

    @RequestMapping("freemarkerTestFeign")
    @ResponseBody
    public String freemarkerTestFeign(){
        return feignService.freemarkerTestByFeign();
    }

    @RequestMapping("404")
    public String test404(){
        return "404";
    }



}
