package com.sun.springcloud.controller;

import com.sun.springcloud.entities.CommonResult;
import com.sun.springcloud.entities.Payment;
import com.sun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springboot.controller
 * @Data: Created in 10:03 2021/5/24
 * @Modified By:
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/select/{id}")
    public CommonResult pay(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryByID(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功！ID：" + id + "PORT:" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败！ID：" + id, null);
        }
    }

    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        int insert = paymentService.create(payment);
        if (insert > 0) {
            return new CommonResult(200, "添加成功", insert);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @GetMapping("/payment/port")
    public String getServerPortPort() {
        return this.serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String zipkin() {
        return "zipkin link test";
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**********service:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("**********instance:" + instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
