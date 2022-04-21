package com.shubao.mq.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @version 1.0
 * @program: spring
 * @description: 主题发布者
 * @author: chris
 * @create: 2022-04-21 11:07
 * @since JDK1.8
 **/
public class MyPublisher {

    // 定义连接工厂
    TopicConnectionFactory factory;

    // 定义连接
    TopicConnection connection;

    // 定义会话
    TopicSession session;

    // 定义发布者
    TopicPublisher publisher;

    // 定义主题
    Topic topic;

    // 定义消息
    Message message;

    public void publishTopic(String topicName, String publishText) {
        try {
            // 创建连接工厂
            factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            // 通过连接工厂创建连接
            connection = factory.createTopicConnection();
            // 启动连接
            connection.start();
            // 创建会话
            session = connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
            // 创建主题
            topic = session.createTopic(topicName);
            // 创建发布者
            publisher = session.createPublisher(topic);
            // 创建消息
            message = session.createTextMessage(publishText);
            // 发送消息
            publisher.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭资源
                if (null != publisher) {
                    publisher.close();
                }
                if (null != session) {
                    session.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
