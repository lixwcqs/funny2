package com.cqs.activemq.demo3.conversion;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;


/**
 * 需要在ApplicationContext.xml中的JmsTemplate中配置默认消息队列
 */
@Component
public class SpringJmsPersonConsumer {

    @Resource
    private JmsTemplate jmsTemplate;

    public Person receiveMessage() throws JMSException {
        Person person = (Person) jmsTemplate.receiveAndConvert();
        return person;
    }
}