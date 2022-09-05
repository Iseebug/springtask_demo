package com.example.springtask_demo;

import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimedTask {

    @Autowired
    RabbitMQServer rabbitMQServer;

    @Autowired
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;

    @Scheduled(cron = "0/3 * * * * ?")
    public void addMaskToMQ() throws Exception {
        String result = rabbitMQServer.sendMsg(RandomStringUtils.randomString(16));
        System.out.println("生产的消息：" + result);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void startDeleteMaskToMQ() throws Exception {
        // 1.获取监听的容器
        MessageListenerContainer container = rabbitListenerEndpointRegistry.getListenerContainer("cloud");
        // 2.开启容器
        if(!container.isRunning()){
            container.start();
            System.out.println("rabbit开启容器");
        }
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void stopDeleteMaskToMQ() throws Exception {
        MessageListenerContainer container = rabbitListenerEndpointRegistry.getListenerContainer("cloud");
        if(container.isRunning()){
            container.stop();
            System.out.println("rabbit关闭容器");
        }
    }
}
