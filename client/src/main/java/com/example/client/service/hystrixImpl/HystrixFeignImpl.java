package com.example.client.service.hystrixImpl;

import com.example.client.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @Classname HystrixFeignImpl
 * @Description TODO
 * @Date 2019-06-05
 * @Created by chen_bq
 */
@Component
public class HystrixFeignImpl implements FeignService {

    @Override
    public String testProduct() {
        return "this is HystrixFeign CallBack";
    }
}
