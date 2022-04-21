package com.shubao.mq.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @version 1.0
 * @program: spring
 * @description: 主题订阅者
 * @author: chris
 * @create: 2022-04-21 10:52
 * @since JDK1.8
 **/
public class MySubscriber implements Runnable {

    // 定义连接工厂
    TopicConnectionFactory factory;

    // JMS连接，属于Pub/Sub方式的连接
    TopicConnection connection;

    // JMS会话，属于Pub/Sub方式的会话
    TopicSession session;

    // 定义消息队列，消息队列名称为：TEST_QUEUE
    Topic topic;

    // 主题订阅者
    TopicSubscriber subscriber;

    // 定义消息
    Message message;

    @Override
    public void run() {
        try {
            // 创建连接工厂
            factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            // 通过工厂创建连接
            connection = factory.createTopicConnection();
            // 开启连接
            connection.start();
            // 创建会话
            session = connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
            // 创建消息队列 参数：主题名称，是否独占，是否支持事务（topic模型）
            topic = session.createTopic("topic");
            // 创建订阅者
            subscriber = session.createSubscriber(topic);
            // 接收消息，会阻塞线程
            message = subscriber.receive();
            // 打印消息
            System.out.println("收到消息：" + ((TextMessage) message).getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭资源
                if (subscriber != null) {
                    subscriber.close();
                }
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

