package com.example.springtask_demo;

import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimedTask {

    @Autowired
    RabbitMQServer rabbitMQServer;

    @Scheduled(cron = "0/10 * * * * ?")
    public void addMaskToMQ() throws Exception {
        //String result = rabbitMQServer.sendMsg(RandomStringUtils.randomString(16));
        System.out.println("result");
    }
}
