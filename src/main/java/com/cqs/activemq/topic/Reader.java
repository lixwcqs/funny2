package com.cqs.activemq.topic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Random;

/**
 * 异步
 * Created by cqs on 11/7/16.
 */
@Scope("prototype")
@Component
public class Reader implements MessageListener {
    private final int id;

    public Reader() {
        this.id = new Random().nextInt(1000);
    }

    public Reader(int id) {
        this.id = id;
    }


    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println(this + "接受到新的消息：" + ((TextMessage) message).getText());
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                '}';
    }
}