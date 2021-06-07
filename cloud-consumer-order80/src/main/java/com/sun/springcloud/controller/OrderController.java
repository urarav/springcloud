package com.sun.springcloud.controller;

import com.sun.springcloud.entities.CommonResult;
import com.sun.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.controller
 * @Data: Created in 13:03 2021/5/24
 * @Modified By:
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/select/{id}")
    public CommonResult<Payment> pay(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/select/" + id, CommonResult.class);
    }

    //远程调用请求体是以JSON形式发送的，8001端insert需要加@RequestBody注解
    @GetMapping("/consumer/payment/insert")
    public CommonResult<Payment> insert(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/pay/{id}")
    public CommonResult<Payment> select(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/select/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info(entity.getStatusCode() + "\t" + entity.getHeaders());
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer//payment/zipkin")
    public String zipkin() {
        String str = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return str;
    }
}
