package com.shubao.mq.activemq.ptp;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @version 1.0
 * @program: spring
 * @description: 消息监听器
 * @author: chris
 * @create: 2022-04-21 10:30
 * @since JDK1.8
 **/
public class MyListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("收到消息：" + textMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

