package com.lingyun.study.rabbitmq.common;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtils {

    public static Channel createChannel() throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.80.128");
        factory.setUsername("admin");
        factory.setPassword("123");
        factory.setVirtualHost("/");//设置虚拟主机，可不写，默认也是这个
        factory.setPort(5672);//设置端口，不设也是这个
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }
}
