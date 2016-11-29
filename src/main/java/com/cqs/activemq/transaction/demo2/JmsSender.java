package com.cqs.activemq.transaction.demo2;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static org.springframework.util.Assert.notNull;

/**
 * Created by cqs on 16-11-28.
 */
@Component
public class JmsSender {
    @Resource
    private JmsTemplate jmsTemplate;

    public void sendMessage() {
        notNull(jmsTemplate);
        jmsTemplate.send(session -> session.createTextMessage("msg"));
    }
}
