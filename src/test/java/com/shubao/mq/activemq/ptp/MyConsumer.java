package com.shubao.mq.activemq.ptp;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @version 1.0
 * @program: spring
 * @description: 消费者
 * @author: chris
 * @create: 2022-04-21 10:30
 * @since JDK1.8
 **/
public class MyConsumer {

    //定义连接工厂
    ConnectionFactory connectionFactory;

    //定义连接
    Connection connection;

    //定义会话
    Session session;

    //定义目的地
    Destination destination;

    //定义消费者
    MessageConsumer consumer;

    //定义消息
    Message message;

    public void init() throws Exception {
        //创建连接工厂
        connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //创建连接
        connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        destination = session.createQueue("myQueue");
        //创建消费者
        consumer = session.createConsumer(destination);

        //接收消息
        // message = consumer.receive();

        //加载监听器
        consumer.setMessageListener(new MyListener());

        //监听器需要持续加载，所以需要一直调用，使用输入流的方式阻塞当前线程结束
        System.in.read();
    }

    public void close() throws Exception {
        //关闭消费者
        consumer.close();
        //关闭会话
        session.close();
        //关闭连接
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        MyConsumer myConsumer = new MyConsumer();
        myConsumer.init();
        System.out.println("接收到的消息是：" + ((TextMessage) myConsumer.message).getText());
        myConsumer.close();
    }
}

