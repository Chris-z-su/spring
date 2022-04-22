package com.shubao.mq.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * @version 1.0
 * @program: spring
 * @description: Topic模式测试类
 *  参考笔记：https://www.cnblogs.com/yuan-xiao-tong/p/9079079.html  自动带出的，没有用
 *          https://gitee.com/zhangsubao/studynotes/blob/master/notes/%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97.md
 * @author: chris
 * @create: 2022-04-21 11:03
 * @since JDK1.8
 **/
public class ActiveMQTest {

    public static void main(String[] args) {
        MySubscriber subscriber = new MySubscriber();
        Thread t1 = new Thread(subscriber);
        Thread t2 = new Thread(subscriber);
        t1.start();
        t2.start();
    }

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
        Topic topic = session.createTopic("mytopic01");
        //通过session对象创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        //创建消息对象
        TextMessage message = session.createTextMessage("ping22");
        //发送消息
        producer.send(message);
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
        //连接MQ服务
        connection.start();
        //创建会话对象
        // Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//自动确认
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);//手动确认
        //通过session对象创建Topic对象
        Topic topic = session.createTopic("mytopic01");
        //通过session对象创建消息消费者
        MessageConsumer consumer = session.createConsumer(topic);
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
                    if(textMessage.getText().equals("ping")){
                        System.out.println("消费者接收到了消息：" + textMessage.getText());
                        //手动确认消息
                        message.acknowledge();
                    }else {
                        //模拟消息处理失败：消费者接收到的消息不是ping，则抛出异常
                        System.out.println("消息处理失败：" + textMessage.getText());
                        //通知MQ服务器，消息处理失败，消息不能被消费者消费，需要重新发送，最多重发6次
                        session.recover();
                        int i = 1/0;
                    }
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
