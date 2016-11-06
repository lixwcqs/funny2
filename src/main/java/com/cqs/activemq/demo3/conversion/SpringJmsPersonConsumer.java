package com.cqs.activemq.demo3.conversion;

import javax.annotation.Resource;
import javax.jms.JMSException;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringJmsPersonConsumer {

	@Resource
	private JmsTemplate jmsTemplate;

	public Person receiveMessage() throws JMSException {
		Person person = (Person) jmsTemplate.receiveAndConvert();
		return person;	
	}
}