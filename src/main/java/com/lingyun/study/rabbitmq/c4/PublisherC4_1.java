package com.lingyun.study.rabbitmq.c4;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * 单个发布确认
 */
public class PublisherC4_1 {
    public static final int TOTAL_COUNT=1000;

    public static void main(String[] args) throws Exception {

        singleConfirm();

    }

    /**
     * 单个发布确认
     */
    private static void singleConfirm() throws Exception {
        Channel channel = RabbitMqUtils.createChannel();
        String queueName=UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);
        //1.开启发布确认
        channel.confirmSelect();
        long begin=System.currentTimeMillis();
        for(int i=1;i<=TOTAL_COUNT;i++) {
            String message=i+"";
            channel.basicPublish("",queueName,null,message.getBytes());
            //发布结果
            boolean confirmed=channel.waitForConfirms();
            if (confirmed){
                System.out.println("消息确认发布："+ i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布"+TOTAL_COUNT+"个单独确认消息，耗时"+(end-begin)+" ms.");
    }
}
