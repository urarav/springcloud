package com.sun.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.springcloud.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.controller
 * @Data: Created in 22:23 2021/6/1
 * @Modified By:
 */
@RestController
@DefaultProperties(defaultFallback = "GlobalFallbackMethod")
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id) {
        return hystrixService.paymentInfoOK(id);
    }

   /* @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Long id) {
        return hystrixService.paymentTimeOut(id);
    }

    public String paymentTimeOutHandler(Long id) {
        return "ThreadPool:" + Thread.currentThread().getName() + "OrderPaymentTimeOutHandler id:" + "\t" + id;
    }

    //全局fallback方法
    public String GlobalFallbackMethod(){
        return "this is GlobalFallbackMethod";
    }
}
