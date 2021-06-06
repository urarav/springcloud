package com.sun.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.controller
 * @Data: Created in 17:48 2021/5/30
 * @Modified By:
 */
@RestController
public class PayController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/pay/consul")
    public String pay() {
        return "springCloud with Consul: serverPort" + serverPort + "\t" + UUID.randomUUID();
    }
}
