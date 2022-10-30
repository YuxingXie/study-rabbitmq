# rabbitMQ个人学习笔记

只是笔记不是教程，仅记录本人学习中的重点、疑难和体会，请学习者见谅。

* 参考资料1

 
    https://www.youtube.com/playlist?list=PLmOn9nNkQxJGqsOsBEs0MPfazE4mI1QIB

跟着学了几章以后发现了不少问题，基本弃用。

* 参考资料2


    https://www.youtube.com/playlist?list=PLVNv4jlPFzXsT078uZ25Fz_dJJmMs0IoN
    
目前使用中。    

## 1. [MQ&RabbitMQ](https://github.com/YuxingXie/study-rabbitmq/blob/main/assets/md/001.MD)

VMware中CentOS设置静态IP:https://blog.csdn.net/yelllowcong/article/details/76293348 ,
要修改的/etc/sysconfig/network-scripts/ifcfg-xxx文件名可能不一样，可以cd到目录看一下。

临时关闭命令： systemctl stop firewalld
永久关闭命令： systemctl disable firewalld
启用UI插件：rabbitmq-plugins enable rabbitmq_management
查看进程:ps -ef|grep rabbitmq
当前窗口启动 rabbitmq:rabbitmq-server
后台启动 rabbitmq:rabbitmq-server -detached
停止 rabbitmq:rabbitmqctl stop

## 2. [Hello world模式](https://github.com/YuxingXie/study-rabbitmq/blob/main/assets/md/002.MD)
简单模式

## 3. [Work Queues模式](https://github.com/YuxingXie/study-rabbitmq/blob/main/assets/md/003.MD)
* 工作队列模式
* 轮询分发
* 不公平分发
* 自动应答
* 手动应答
* 队列持久化
* 消息持久化

## 4. [发布确认](https://github.com/YuxingXie/study-rabbitmq/blob/main/assets/md/004.MD)

## 5. [交换机](https://github.com/YuxingXie/study-rabbitmq/blob/main/assets/md/005.MD)
broker
exchanges



