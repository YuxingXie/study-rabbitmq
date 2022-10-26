package com.lingyun.study.rabbitmq.c3;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class PublisherC3_1 {
    //队列名
    //发消息
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Channel channel = RabbitMqUtils.createChannel();

        channel.queueDeclare(ConsumerC3_1.QUEUE_NAME,false,false,false,null);
        String message;
        int index = 1;
        while(true) {
            message="message "+index;
            channel.basicPublish("",ConsumerC3_1.QUEUE_NAME,null,message.getBytes());
            System.out.println("消息已发送:"+message);
            Thread.sleep(2500);
            index++;
        }

        //加上两个close,main方法才会释放资源并exit
//        channel.close();
//        connection.close();
    }
}
