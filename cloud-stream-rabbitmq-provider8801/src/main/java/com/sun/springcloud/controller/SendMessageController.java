package com.sun.springcloud.controller;

import com.sun.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.service
 * @Data: Created in 21:39 2021/6/7
 * @Modified By:
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageService iMessageService;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessageService.send();
    }

}
