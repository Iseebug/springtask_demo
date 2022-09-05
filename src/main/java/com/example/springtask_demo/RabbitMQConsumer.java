package com.example.springtask_demo;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queuesToDeclare = @Queue(MQParams.RABBITMQ_DEMO_TOPIC), autoStartup= "false", id = "cloud")
public class RabbitMQConsumer {

    @RabbitHandler
    public void proceess(Map map) {
        System.out.println("消费者RabbitMQConsumer从mq服务端口消费消息：" + map.toString());
    }

}
