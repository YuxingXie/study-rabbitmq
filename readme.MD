# rabbitMQ个人学习笔记

只是笔记不是教程，仅记录本人学习中的重点、疑难和体会，请学习者见谅。

参考视频： https://www.youtube.com/playlist?list=PLmOn9nNkQxJGqsOsBEs0MPfazE4mI1QIB

## 1. [MQ&RabbitMQ](https://github.com/YuxingXie/study-rabbitmq/blob/main/assets/md/001.MD)

VMware中CentOS设置静态IP:https://blog.csdn.net/yelllowcong/article/details/76293348
临时关闭命令： systemctl stop firewalld
永久关闭命令： systemctl disable firewalld
启用UI插件：rabbitmq-plugins enable rabbitmq_management
##### 查看进程
ps -ef|grep rabbitmq
##### 当前窗口启动 rabbitmq
rabbitmq-server
##### 后台启动 rabbitmq
rabbitmq-server -detached
##### 停止 rabbitmq
rabbitmqctl stop
##### 查看所有队列
rabbitmqctl list_queues
##### 查看所有虚拟主机
rabbitmqctl list_vhosts
##### 在Erlang VM运行的情况下启动RabbitMQ应用
rabbitmqctl start_app 
rabbitmqctl stop_app
##### 查看节点状态
rabbitmqctl status
##### 查看所有可用的插件
rabbitmq-plugins list
##### 启用插件
rabbitmq-plugins enable <plugin-name>eg: rabbitmq-plugins enable rabbitmq_management
##### 停用插件
rabbitmq-plugins disable <plugin-name>
##### 添加用户
rabbitmqctl add_user username password
##### 列出所有用户
rabbitmqctl list_users
##### 删除用户
rabbitmqctl delete_user username
##### 清除用户权限
rabbitmqctl clear_permissions -p vhostpath username
##### 列出用户权限
rabbitmqctl list_user_permissions username
##### 修改密码
rabbitmqctl change_password username newpassword
##### 设置用户权限
rabbitmqctl set_permissions -p vhostpath username ".*" ".*" ".*"
##### 创建虚拟主机
rabbitmqctl add_vhost vhostpath
##### 列出虚拟主机上的所有权限
rabbitmqctl list_permissions -p vhostpath
##### 删除虚拟主机
rabbitmqctl delete_vhost vhost vhostpath
##### 移除所有数据，要在 rabbitmqctl stop_app 之后使用
rabbitmqctl reset

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



