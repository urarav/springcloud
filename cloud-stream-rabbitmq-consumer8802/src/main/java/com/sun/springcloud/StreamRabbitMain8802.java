package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud
 * @Data: Created in 22:10 2021/6/7
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMain8802.class, args);
    }
}
