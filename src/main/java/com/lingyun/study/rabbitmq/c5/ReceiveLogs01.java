package com.lingyun.study.rabbitmq.c5;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

public class ReceiveLogs01 {
    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        //声明临时队列
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, EXCHANGE_NAME, "logs_key1");
//        channel.queueBind(queue, EXCHANGE_NAME, "logs_key1");
        channel.basicConsume(queue, true, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) {
                System.out.println("01 get message:" + new String(message.getBody(), StandardCharsets.UTF_8));
            }
        }, new CancelCallback() {
            @Override
            public void handle(String consumerTag) {

            }
        });
    }
}
