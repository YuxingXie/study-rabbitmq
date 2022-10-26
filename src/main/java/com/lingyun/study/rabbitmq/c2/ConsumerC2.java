package com.lingyun.study.rabbitmq.c2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
//类名后的C2表示第2章，是为了区分其它章节的同名的类，避免引入时引入错了
public class ConsumerC2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.80.128");
        factory.setUsername("admin");
        factory.setPassword("123");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //学习的时候lambda表达式虽然简洁我却不建议写，因为它隐藏了接口名方法名及参数类型，不利于展示这些信息，除非你对这些滚瓜烂熟。另外语法简洁也不是java追求的特征。
        channel.basicConsume(ProducerC2.QUEUE_NAME, true, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) {
                //打印的值是：amq.ctag-VaUNijySkhTKN-qgWJ9ELw
                System.out.println("deliverCallback consumerTag:" + consumerTag);

                System.out.println("deliverCallback message:" + new String(message.getBody()));//hello rabbit!
            }
        }, new CancelCallback() {
            @Override
            public void handle(String consumerTag) {
                System.out.println("cancelCallback consumerTag:" + consumerTag);

            }
        });
    }
}
