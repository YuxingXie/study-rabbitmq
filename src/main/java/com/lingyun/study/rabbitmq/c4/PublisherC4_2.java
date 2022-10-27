package com.lingyun.study.rabbitmq.c4;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.util.UUID;


public class PublisherC4_2 {
    public static final int TOTAL_COUNT=1000;

    public static void main(String[] args) throws Exception {

        multipleConfirm();

    }

    /**
     * 批量发布确认
     */
    private static void multipleConfirm() throws Exception {
        Channel channel = RabbitMqUtils.createChannel();
        String queueName=UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);
        //1.开启发布确认
        channel.confirmSelect();
        long begin=System.currentTimeMillis();
        int fetchSize=0;
        for(int i=1;i<=TOTAL_COUNT;i++) {
            String message=i+"";
            channel.basicPublish("",queueName,null,message.getBytes());
            fetchSize++;
            if (fetchSize==100){//每100个消息批量确认一下
                //发布结果
                boolean confirmed=channel.waitForConfirms();


                if (confirmed){
                    System.out.println("消息确认发布："+ i);
                }else {
                    System.out.println("消息发布失败了："+ i);
                }
                fetchSize=0;
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("发布"+TOTAL_COUNT+"个单独确认消息，耗时"+(end-begin)+" ms.");

    }
}
