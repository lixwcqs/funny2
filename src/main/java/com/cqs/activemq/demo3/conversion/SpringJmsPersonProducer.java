package com.cqs.activemq.demo3.conversion;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SpringJmsPersonProducer {

	@Resource
	private JmsTemplate jmsTemplate;

	public void sendMessage(final Person person) {
        jmsTemplate.convertAndSend(person);
	}
}