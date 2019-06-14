package com.example.gateway.bean;

import com.example.gateway.util.CommonUtils;
import com.example.gateway.util.SpringContextUtils;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AddRequestParameterGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RequestRateLimiterGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.util.Map;

/**
 * @Classname GatewayBean
 * @Description TODO
 * @Date 2019-06-12
 * @Created by chen_bq
 */
@Component
@Order(2)
public class GatewayBean {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        //配置redisratelimit
        RedisRateLimiter redisRateLimiter = new RedisRateLimiter(1,1);
        redisRateLimiter.setApplicationContext(SpringContextUtils.getContext());

        return builder.routes()
                //配置了一个 miao? 的路由
                .route("miao1", r -> r.path("/product")
                        .uri("http://localhost:9010"))
                .route("miao2", r -> r.path("/clientFeign")
                        .uri("http://localhost:9020"))
                .route("miao3", r -> r.path("/comma")
                        .uri("https://www.baidu.com/?"))
//                .route("miao4", r -> r.path("/paramProduct")
//                        //设置过滤器自动补充参数，参数必须加密，否则默认不会加密，传递的特殊符号将会引起信息异常
//                        .filters(f -> f.addRequestParameter("param"
//                                , CommonUtils.defaultEnCoderUri("<h1>Test default param method</h1>")))
//                        .uri("http://localhost:9010"))
                .route("miao5", r -> r.path("/paramFeign")
                        .filters(f -> f.addRequestParameter("param"
                                , CommonUtils.defaultEnCoderUri("<h1>Test feign use product default param method</h1><hr/><h1>中文测试</h1>"))
                                //hystrix配置为该路由的熔断配置，即一级熔断之后可以通过forward在gateway内再次跳转另一级
//                                .hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/gatewayFallBack"))
                                //测试路由其他可用服务，结果：不可直接再路由
//                                .hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/product"))
                                //测试gateway外再路由，即gateway服务内创建子控制层做再路由，结果：显而易见的通过。但这种方式不够优雅
//                                .hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/forwardOtherService"))
                                //需要事先配好redisratelimit
                                .requestRateLimiter(rl -> rl.setRateLimiter(redisRateLimiter)
                                )
                        )
                        .uri("http://localhost:9020"))
                .build();
        // 配置解释：
        // 给配置路由ID为miao？ 的clientFeign到localhost:9020/clientFeign  可以类比成nginx的rewrite的方式
        // 但是又不完全是rewrite的方式
        // 因为如第三的路由配置的话，路由的路径就变成了https://www.baidu.com/comma 而不是 https://www.baidu.com/?comma
    }



}
