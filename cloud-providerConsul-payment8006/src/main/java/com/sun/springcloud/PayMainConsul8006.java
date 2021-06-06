package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud
 * @Data: Created in 17:46 2021/5/30
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PayMainConsul8006 {
    public static void main(String[] args) {
        SpringApplication.run(PayMainConsul8006.class, args);
    }
}
