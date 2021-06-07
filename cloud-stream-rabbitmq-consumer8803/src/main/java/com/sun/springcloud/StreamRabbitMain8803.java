package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud
 * @Data: Created in 22:58 2021/6/7
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMain8803.class, args);
    }
}
