package com.shubao.mq.activemq.topic;

import org.junit.Test;

/**
 * @version 1.0
 * @program: spring
 * @description: 发布Topic消息测试类
 * @author: chris
 * @create: 2022-04-21 11:18
 * @since JDK1.8
 **/
public class PublisherTest {

    @Test
    public void topicPublishTest() {
        MyPublisher publisher = new MyPublisher();
        publisher.publishTopic("topic", "hello, topic");
    }
}
