package com.lingyun.study.rabbitmq.c3;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerC3_1 {
    public static final String QUEUE_NAME="queue_hello_c3";
    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = RabbitMqUtils.createChannel();
        channel.basicQos(5);
        channel.basicConsume(QUEUE_NAME, true, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) {
                System.out.println("deliverCallback message:" + new String(message.getBody()));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new CancelCallback() {
            @Override
            public void handle(String consumerTag) {
                System.out.println("cancelCallback consumerTag:" + consumerTag);
            }
        });
    }
}
