package com.cqs.activemq.transaction.demo2;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.springframework.util.Assert.notNull;

/**
 * Created by cqs on 16-11-28.
 */
@Component
public class JmsSender {
    @Resource
    private JmsTemplate jmsTemplate;

    @Transactional
    public void sendMessage() {
        notNull(jmsTemplate);
        jmsTemplate.send(session -> session.createTextMessage("msg"));
        throw new RuntimeException("发送消息异常");
    }
}
