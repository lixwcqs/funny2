package com.cqs.activemq.demo3.conversion;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class PersonMessageConverter implements MessageConverter{

	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {		
		Person person = (Person) object;
		MapMessage message = session.createMapMessage();
		message.setString("name", person.getName());
		message.setInt("age", person.getAge());
		return message;
	}

	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		MapMessage mapMessage = (MapMessage) message;
		Person person = new Person(mapMessage.getString("name"), mapMessage.getInt("age"));
		return person;
	}

}