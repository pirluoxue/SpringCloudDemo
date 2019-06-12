package com.example.gateway.bean;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Classname GatewayBean
 * @Description TODO
 * @Date 2019-06-12
 * @Created by chen_bq
 */
@Component
public class GatewayBean {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //配置了一个 miao? 的路由
                .route("miao?", r -> r.path("/clientFeign")
                        .uri("http://localhost:9020"))
                .route("miao??", r -> r.path("/product")
                        .uri("http://localhost:9010"))
                .route("miao???", r -> r.path("/comma")
                        .uri("https://www.baidu.com/?"))
                .build();
        // 配置解释：
        // 给配置路由ID为miao？ 的clientFeign到localhost:9020/clientFeign  可以类比成nginx的rewrite的方式
        // 但是又不完全是rewrite的方式
        // 因为如第三的路由配置的话，路由的路径就变成了https://www.baidu.com/comma 而不是 https://www.baidu.com/?comma
    }


}
