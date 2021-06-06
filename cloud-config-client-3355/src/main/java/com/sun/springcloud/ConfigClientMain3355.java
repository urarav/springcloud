package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud
 * @Data: Created in 0:03 2021/6/7
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }
}
