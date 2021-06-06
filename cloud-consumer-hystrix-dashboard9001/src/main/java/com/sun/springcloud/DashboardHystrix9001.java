package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud
 * @Data: Created in 19:21 2021/6/4
 * @Modified By:
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardHystrix9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboardHystrix9001.class, args);
    }
}
