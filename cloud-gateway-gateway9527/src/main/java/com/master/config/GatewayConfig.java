package com.master.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/12/21 10:28
 */
@Configuration
public class GatewayConfig {
    //网关路由的另一种配置
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes=builder.routes();
        routes.route("path_route_colorxjh",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();

    }
}
