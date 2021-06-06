package com.sun.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.controller
 * @Data: Created in 18:09 2021/5/30
 * @Modified By:
 */
@RestController
public class OrderController {
    private static final String PAYMENT_URL = "http://consul-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/consul")
    public String order() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/consul", String.class);
    }
}
