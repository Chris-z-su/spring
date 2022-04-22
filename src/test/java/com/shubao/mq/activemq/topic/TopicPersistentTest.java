package com.shubao.mq.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * @version 1.0
 * @program: spring
 * @description: 消息持久化测试类：持久化消息到本地文件
 * @author: chris
 * @create: 2022-04-22 10:34
 * @since JDK1.8
 **/
public class TopicPersistentTest {

    /**
     * @description: 消息发送方--生产者
     */
    @Test
    public void test1() throws JMSException {
        //创建链接工厂对象
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //从链接工厂中获取链接对象
        Connection connection = connectionFactory.createConnection();
        //连接MQ服务
        connection.start();
        //创建会话对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //通过session对象创建Topic对象
        Topic topic = session.createTopic("mytopic02");
        //通过session对象创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        //生产者设置持久化， 不设置的话，默认就是持久化
        // producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //创建消息对象
        TextMessage message = session.createTextMessage("ping");
        //发送消息
        // producer.send(message);
        //发送消息并持久化 设置优先级，默认是4，范围是0-9，0最高，9最低 优先级越高，越先发送，但是如果消息持久化，优先级不会起作用，会被覆盖
        // producer.send(message, DeliveryMode.PERSISTENT, Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE);
        producer.send(message, DeliveryMode.PERSISTENT, 1, 1000*60*60*24);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }

    /**
     * @description: 消息消费方--消费者
     */
    @Test
    public void test2() throws JMSException, IOException {
        //创建链接工厂对象
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //从链接工厂中获取链接对象
        Connection connection = connectionFactory.createConnection();
        //设置客户端ID
        connection.setClientID("myclient01");
        //连接MQ服务
        connection.start();
        //创建会话对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//自动确认
        // Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);//手动确认
        //通过session对象创建Topic对象
        Topic topic = session.createTopic("mytopic02");
        //通过session对象创建消息消费者
        // MessageConsumer consumer = session.createConsumer(topic);
        //客户端持久化订阅
        TopicSubscriber consumer = session.createDurableSubscriber(topic, "myclient01-sub01");
        // MessageConsumer consumer = session.createDurableSubscriber(topic, "myclient01-sub01");
        //接收消息
        // TextMessage message = (TextMessage) consumer.receive();
        //设置消息监听器
        consumer.setMessageListener(new MessageListener() {
            /**
             * @description: 消息监听器：当前监听的topic中存在消息时，会自动调用该方法
             * @param: message
             * @return: void
             */
            @Override
            public void onMessage(Message message) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("消费者接收到了消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //等待消息
        System.in.read();
        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
