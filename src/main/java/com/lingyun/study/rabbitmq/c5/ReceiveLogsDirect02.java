package com.lingyun.study.rabbitmq.c5;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReceiveLogsDirect02 {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.createChannel();
        //声明交换机
//        channel.exchangeDeclare(ReceiveLogsDirect01.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //声明临时队列
        channel.queueDeclare("console",false,false,false,null);
        channel.queueBind("console",ReceiveLogsDirect01.EXCHANGE_NAME,"info");
        channel.queueBind("console",ReceiveLogsDirect01.EXCHANGE_NAME,"warning");
        channel.basicConsume("console", true, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) {
                System.out.println("get info&warning message:"+new String(message.getBody(), StandardCharsets.UTF_8));
            }
        }, new CancelCallback() {
            @Override
            public void handle(String consumerTag) {

            }
        });
    }
}
