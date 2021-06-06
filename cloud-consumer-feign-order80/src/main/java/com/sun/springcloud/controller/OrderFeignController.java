package com.sun.springcloud.controller;

import com.sun.springcloud.entities.CommonResult;
import com.sun.springcloud.entities.Payment;
import com.sun.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.controller
 * @Data: Created in 0:02 2021/6/1
 * @Modified By:
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/consumer/payment/select/{id}")
    public CommonResult<Payment> query(@PathVariable("id") Long id) {
        CommonResult result = orderFeignService.pay(id);
        return result;
    }
}
