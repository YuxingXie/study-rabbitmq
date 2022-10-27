package com.lingyun.study.rabbitmq.c4;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.io.IOException;
import java.util.UUID;


public class PublisherC4_3 {
    public static final int TOTAL_COUNT=1000;

    public static void main(String[] args) throws Exception {

        asyncConfirm();

    }

    /**
     * 异步ack
     */
    private static void asyncConfirm() throws Exception {
        Channel channel = RabbitMqUtils.createChannel();
        String queueName=UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);
        //1.开启发布确认
        channel.confirmSelect();
        //监听回调
        channel.addConfirmListener(new ConfirmCallback() {
            @Override
            public void handle(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("ack deliveryTag:"+deliveryTag+" , multiple:"+multiple);
            }
        }, new ConfirmCallback() {
            @Override
            public void handle(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("nack deliveryTag:"+deliveryTag+" , multiple:"+multiple);
            }
        });
        long begin=System.currentTimeMillis();
        int fetchSize=0;
        for(int i=1;i<=TOTAL_COUNT;i++) {
            String message="message "+i;
            channel.basicPublish("",queueName,null,message.getBytes());
            System.out.println("message published : "+message);
            //有监听器处理发布结果，所以这里不用逐个确认
//          boolean confirmed=channel.waitForConfirms();

        }
        long end = System.currentTimeMillis();
        System.out.println("异步ack"+TOTAL_COUNT+"个消息，发布耗时"+(end-begin)+" ms.");
    }
}
