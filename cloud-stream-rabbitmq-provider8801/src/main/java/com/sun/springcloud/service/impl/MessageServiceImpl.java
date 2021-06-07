package com.sun.springcloud.service.impl;

import com.sun.springcloud.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.service.impl
 * @Data: Created in 21:16 2021/6/7
 * @Modified By:
 */
//定义消息的推送管道将Channel和Exchanges绑定在一起
@EnableBinding(Source.class)
public class MessageServiceImpl implements IMessageService {

    //消息发送管道（信道）
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> message = MessageBuilder.withPayload(serial).build();
        output.send(message);
        System.out.println("serial:" + serial);
        return serial;
    }

}
