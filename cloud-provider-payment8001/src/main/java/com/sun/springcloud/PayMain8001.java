package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springboot
 * @Data: Created in 1:06 2021/5/24
 * @Modified By:
 */

/*new Module->pom->yaml->main()->service*/

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PayMain8001 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PayMain8001.class, args);
    }
}
