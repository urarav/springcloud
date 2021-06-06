package com.sun.springcloud.service;

import com.sun.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.service
 * @Data: Created in 0:00 2021/6/1
 * @Modified By:
 */

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderFeignService {

    @GetMapping("/payment/select/{id}")
    public CommonResult pay(@PathVariable("id") Long id);
}
