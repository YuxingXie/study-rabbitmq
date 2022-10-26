package com.lingyun.study.rabbitmq.c2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者发消息给队列
 */
//类名后的C2表示第2章，是为了区分其它章节的同名的类，避免引入时引错了
public class ProducerC2 {
    //队列名
    public static final String QUEUE_NAME="queue_hello";
    //发消息
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.80.128");
//        factory.setPort(15672);//别搞错，不要端口

        factory.setUsername("admin");
        factory.setPassword("123");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //代码写到这里想想，哪个对象负责发消息？
        //生成一个队列,参数见API说明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message="hello rabbit!";
        //由信道发送消息到交换机的队列里面
        //第一个参数是交换机，不知道填什么就空字符串，千万别填null
        //这里第二个参数为路由key，不知道有什么含义，暂时写队列名
        int index = 1;
        while(true) {
            message="hello rabbit "+index +" !";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("消息已发送:"+message);
            Thread.sleep(2500);
            index++;
        }

        //加上两个close,main方法才会释放资源并exit
//        channel.close();
//        connection.close();
    }
}
