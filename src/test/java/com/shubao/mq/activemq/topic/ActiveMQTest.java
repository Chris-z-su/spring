package com.shubao.mq.activemq.topic;

/**
 * @version 1.0
 * @program: spring
 * @description: Topic模式测试类
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
}
