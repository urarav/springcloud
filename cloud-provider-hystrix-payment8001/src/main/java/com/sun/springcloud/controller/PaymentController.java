package com.sun.springcloud.controller;

import com.sun.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.controller
 * @Data: Created in 21:08 2021/6/1
 * @Modified By:
 */
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id){
        return paymentService.paymentInfoOK(id);
    }

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Long id){
        return paymentService.paymentTimeOut(id);
    }


    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
