package com.example.springtask_demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RabbitMQConfig implements BeanPostProcessor {

    /**
     * 这是创建交换机和队列用的rabbitAdmin对象
     */
    @Resource
    private RabbitAdmin rabbitAdmin;

    /**
     * 实例化bean后，也就是Bean的后置处理器
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //创建交换机
        rabbitAdmin.declareExchange(rabbitmqDirectExchange());
        //创建队列
        rabbitAdmin.declareQueue(rabbitmqDirectQueue());
        return null;
    }

    @Bean
    public Queue rabbitmqDirectQueue() {
        /**
         * 1、name:    队列名称
         * 2、durable: 是否持久化
         * 3、exclusive: 是否独享、排外的。如果设置为true，定义为排他队列。则只有创建者可以使用此队列。也就是private私有的。
         * 4、autoDelete: 是否自动删除。也就是临时队列。当最后一个消费者断开连接后，会自动删除。
         * */
        return new Queue(MQParams.RABBITMQ_DEMO_TOPIC, true, false, false);
    }

    @Bean
    public DirectExchange rabbitmqDirectExchange() {
        //交换机
        return new DirectExchange(MQParams.RABBITMQ_DEMO_DIRECT_EXCHANGE, true, false);
    }

    @Bean
    public Binding bindDirect() {
        //链式写法，绑定交换机和队列，并设置匹配键
        return BindingBuilder.bind(rabbitmqDirectQueue()).to(rabbitmqDirectExchange()).with(MQParams.RABBITMQ_DEMO_DIRECT_ROUTING);
    }
}
