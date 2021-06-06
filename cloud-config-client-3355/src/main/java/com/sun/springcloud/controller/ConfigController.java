package com.sun.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.controller
 * @Data: Created in 0:08 2021/6/7
 * @Modified By:
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    public String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return this.configInfo;
    }
}
