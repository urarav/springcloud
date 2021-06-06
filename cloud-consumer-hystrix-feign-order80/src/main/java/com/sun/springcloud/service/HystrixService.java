package com.sun.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.service
 * @Data: Created in 22:23 2021/6/1
 * @Modified By:
 */
@Component
@FeignClient(value = "cloud-hystrix-payment-service", fallback = FallbackService.class)
public interface HystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Long id);
}