package com.example.gateway.bean;

import com.example.gateway.util.SpringContextUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.factory.RequestRateLimiterGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * @Classname config
 * @Description TODO
 * @Date 2019-06-13
 * @Created by chen_bq
 */
@Component
@Order(1)
public class RateLimitConfig {

//    @Bean
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
//    }

//    @Bean
//    public KeyResolver ipKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
//    }

    @Bean
    public KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

//    @Bean
//    public RateLimiter rateLimiter(){
//        RedisRateLimiter redisRateLimiter = SpringContextUtils.getBean(RedisRateLimiter.class);
//        Map<String, RedisRateLimiter.Config> map = redisRateLimiter.getConfig();
//        RedisRateLimiter.Config config = new RedisRateLimiter.Config();
//        config.setBurstCapacity(1);
//        config.setReplenishRate(1);
////        map.put("gateway_route2", config);
//        map.put("maio5", config);
//        return redisRateLimiter;
//    }

}
