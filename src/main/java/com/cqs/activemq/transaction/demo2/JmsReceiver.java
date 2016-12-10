package com.cqs.activemq.transaction.demo2;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by cqs on 16-11-28.
 */
@Component("jmsReceiver")
public class JmsReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("接受消息:\t" + message);
//        throw new RuntimeException("error");
    }
}
