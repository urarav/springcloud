package com.sun.springcloud.service.ServiceImpl;

import com.sun.springcloud.entities.Payment;
import com.sun.springcloud.mapper.PaymentMapper;
import com.sun.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springboot.service.ServiceImpl
 * @Data: Created in 10:02 2021/5/24
 * @Modified By:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired(required = false)
    private PaymentMapper paymentMapper;

    @Override
    public Payment queryByID(Long id) {
        return paymentMapper.queryByID(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }
}
