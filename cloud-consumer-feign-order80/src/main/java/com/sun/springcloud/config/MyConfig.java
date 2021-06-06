package com.sun.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.config
 * @Data: Created in 0:32 2021/6/1
 * @Modified By:
 */
@Configuration
public class MyConfig {
    @Bean
    Logger.Level logLevel() {
        return Logger.Level.FULL;//日志级别
    }
}
