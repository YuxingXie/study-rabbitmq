package com.lingyun.study.rabbitmq.c5;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import java.util.Scanner;

public class EmitLog {
    public static void main(String[] args) throws Exception {
        Channel channel =  RabbitMqUtils.createChannel();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String message = scanner.next();
            channel.basicPublish(ReceiveLogs01.EXCHANGE_NAME,"",null,message.getBytes());
        }
    }
}
