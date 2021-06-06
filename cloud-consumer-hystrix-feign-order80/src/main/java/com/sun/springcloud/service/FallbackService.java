package com.sun.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.service
 * @Data: Created in 1:10 2021/6/4
 * @Modified By:
 */
@RestController
public class FallbackService implements HystrixService {
    @Override
    public String paymentInfoOK(Long id) {
        return "FallbackService_paymentInfoOK";
    }

    @Override
    public String paymentTimeOut(Long id) {
        return "FallbackService_paymentTimeOut";
    }
}
