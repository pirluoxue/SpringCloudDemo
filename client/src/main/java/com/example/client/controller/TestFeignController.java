package com.example.client.controller;

import com.example.client.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return feignService.testProduct();
    }

}
