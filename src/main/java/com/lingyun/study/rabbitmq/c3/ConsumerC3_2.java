package com.lingyun.study.rabbitmq.c3;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 手动应答方式
 */
public class ConsumerC3_2 {
    public static final String QUEUE_NAME="queue_hello_c3";
    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = RabbitMqUtils.createChannel();
        //手动应答，第二个参数为false
        channel.basicConsume(QUEUE_NAME, false, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
                System.out.println("deliverCallback message:" + new String(message.getBody()));
            }
        }, new CancelCallback() {
            @Override
            public void handle(String consumerTag) {
                System.out.println("cancelCallback consumerTag:" + consumerTag);
            }
        });
    }
}
