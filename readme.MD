# rabbitMQ个人学习笔记

## 1. MQ入门知识

是什么：消息队列

有什么用：流量削峰，应用解耦，异步处理

分类：ActiveMQ，Kafka,RocketMQ,RabbitMQ

## 2. RabbitMQ概念

它是一个消息中间件，接收并转发消息。

核心概念：生产者、交换机、队列、消费者

核心部分：

1. Hello World（简单模式）
2. Work queues(工作模式)
3. Publish/Subscribe(发布/订阅模式)
4.Routing(路由模式)
5.Topics(主题模式)
6.Publisher Confirms(发布确认模式)

可以认为是6种工作模式。

![](https://github.com/YuxingXie/study-rabbitmq/raw/main/assets/img/001.png)