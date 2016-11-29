package com.cqs.activemq.demo3;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class SpringJmsConsumer {
    @Resource
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination destination;

    public String receiveMessage() throws JMSException {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        return textMessage.getText();
    }
}


//@Component
//public class SpringJmsConsumer implements MessageListener{
//
//    @Override
//    public void onMessage(Message message) {
//
//    }
//}