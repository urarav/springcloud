package com.sun.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.config
 * @Data: Created in 13:51 2021/5/24
 * @Modified By:
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    //负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
