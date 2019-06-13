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
    public String product() {
        return "this is HystrixFeign CallBack";
    }

    @Override
    public String paramProductByFeign(String param) {
        StringBuilder error = new StringBuilder();
        error.append("<h1>paramProduct was CallBack</h1>");
        error.append("<h1>causeBy param has error</h1>");
        return error.toString();
    }
}
