package com.lingyun.study.rabbitmq.c5;

import com.lingyun.study.rabbitmq.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

public class EmitLogDirect {
    public static void main(String[] args) throws Exception {
        Channel channel =  RabbitMqUtils.createChannel();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String message = scanner.next();
            String routingKey = "warning";
            if (message.length()<3){
                routingKey="info";
            }else if (message.length()>6){
                routingKey = "error";
            }
            System.out.println(routingKey);
            channel.basicPublish(ReceiveLogsDirect01.EXCHANGE_NAME,routingKey,null,message.getBytes());
        }
    }
}
