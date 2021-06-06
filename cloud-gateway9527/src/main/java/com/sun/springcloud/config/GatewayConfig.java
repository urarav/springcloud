package com.sun.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.config
 * @Data: Created in 12:39 2021/6/5
 * @Modified By:
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("customerGateway",
                r -> r.path("/atguigu")
                        .uri("https://www.yuque.com/atguigu")).build();
        return routes.build();
    }
}
