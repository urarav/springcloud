package com.sun.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;


import java.util.concurrent.TimeUnit;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.service
 * @Data: Created in 21:01 2021/6/1
 * @Modified By:
 */
@Service
public class PaymentService {

    public String paymentInfoOK(Long id) {
        return "ThreadPool:" + Thread.currentThread().getName() + "PaymentInfoOK id:" + "\t" + id;
    }

    //服务降级
    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeOut(Long id) {
        Integer sleepTime = 5;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ThreadPool:" + Thread.currentThread().getName() + "paymentTimeOut id:" + "\t" + id;
    }

    public String paymentTimeOutHandler(Long id) {
        return "ThreadPool:" + Thread.currentThread().getName() + "paymentTimeOutHandler id:" + "\t" + id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否启用断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功: " + id + "流水号: " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "id不能为负数";
    }
}
