package com.lingyun.study.rabbitmq.c3;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;


public class PublisherC3_1 {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Channel channel = RabbitMqUtils.createChannel();
        channel.queueDeclare(ConsumerC3_1.QUEUE_NAME,true,false,false,null);
        String message=null;
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()) {
//            message=scanner.next();
//            //持久化消息
//            channel.basicPublish("",ConsumerC3_1.QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("UTF-8"));
//            System.out.println("消息已发送:"+message);
//        }
        for(int i=0;i<2400;i++) {
            channel.basicPublish("",ConsumerC3_1.QUEUE_NAME,null,(i+"").getBytes("UTF-8"));
            System.out.println("消息已发送:"+i);
            Thread.sleep(30);
        }

        //加上两个close,main方法才会释放资源并exit
//        channel.close();
//        connection.close();
    }
}
