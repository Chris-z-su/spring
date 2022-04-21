package com.shubao.mq.activemq.ptp;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @version 1.0
 * @program: spring
 * @description: 消息生产者
 * @author: chris
 * @create: 2022-04-21 10:30
 * @since JDK1.8
 **/
public class MyProducer {

    //定义连接工厂
    ConnectionFactory connectionFactory;

    //定义连接
    Connection connection;

    //定义session会话
    Session session;

    //定义消息目的地
    Destination destination;

    //定义消息生产者
    MessageProducer producer;

    //定义消息
    Message message;

    public void init() throws JMSException {
        //创建连接工厂
        connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //创建连接
        connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建session会话，第一个参数是是否开启事务，第二个参数是自动确认模式
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建消息目的地，Queue：消息类型是队列，Topic：消息类型是主题
        destination = session.createQueue("myQueue");
        //创建消息生产者
        producer = session.createProducer(destination);
        //设置消息生产者的持久化
        // producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //创建消息
        message = session.createTextMessage("hello world");
    }

    public void sendMessage(String message) throws JMSException {
        //创建消息
        TextMessage textMessage = session.createTextMessage(message);
        //发送消息
        producer.send(textMessage);
    }

    public void close() throws JMSException {
        //关闭消息生产者
        producer.close();
        //关闭会话
        session.close();
        //关闭连接
        connection.close();
    }

    @Test
    public void sentToActiveMQ(){
        try {
            /*
             * 创建连接工厂，由 ActiveMQ 实现。构造方法参数
             * userName 用户名
             * password 密码
             * brokerURL 访问 ActiveMQ 服务的路径地址，结构为: 协议名://主机地址:端口号
             */
            connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");
            //创建连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            /*
             * 创建会话，参数含义:
             * 1.transacted - 是否使用事务
             * 2.acknowledgeMode - 消息确认机制，可选机制为：
             *  1）Session.AUTO_ACKNOWLEDGE - 自动确认消息
             *  2）Session.CLIENT_ACKNOWLEDGE - 客户端确认消息机制
             *  3）Session.DUPS_OK_ACKNOWLEDGE - 有副本的客户端确认消息机制
             */
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建消息目的地，也就是队列名，Queue：消息类型是队列，Topic：消息类型是主题
            destination = session.createQueue("myQueue");
            //创建消息生产者
            producer = session.createProducer(destination);
            //创建消息
            message = session.createTextMessage("hello world");
            //发送消息
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭消息生产者
                if (producer != null) {
                    producer.close();
                }
                //关闭会话
                if (session != null) {
                    session.close();
                }
                //关闭连接
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
