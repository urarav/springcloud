package com.sun.springcloud.service;

import com.sun.springcloud.entities.Payment;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springboot.service.PaymentService
 * @Data: Created in 10:00 2021/5/24
 * @Modified By:
 */

public interface PaymentService {
    public Payment queryByID(Long id);
    public int create(Payment payment);
}
