package com.example.client.service;

import com.example.client.service.hystrixImpl.HystrixFeignImpl;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname FeignService
 * @Description feign服务调用接口类，调用product服务
 * @Date 2019-06-04
 * @Created by chen_bq
 */
@FeignClient(name = "spring-cloud-producer", fallback = HystrixFeignImpl.class)
@Service
public interface FeignService {

    @RequestMapping(value = "product")
    public String product();

    @RequestMapping(value = "paramProduct")
    public String paramProductByFeign(@RequestParam String param);

    @RequestMapping(value = "freemarker")
    public String freemarkerTestByFeign();

}
