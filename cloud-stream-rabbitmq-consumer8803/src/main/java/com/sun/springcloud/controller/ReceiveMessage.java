package com.sun.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springcloud.controller
 * @Data: Created in 22:59 2021/6/7
 * @Modified By:
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessage {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message) {
        System.out.println("port: " + serverPort + "\t" + "message: " + message.getPayload());
    }
}
