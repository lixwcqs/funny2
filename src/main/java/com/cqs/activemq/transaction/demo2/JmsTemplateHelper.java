package com.cqs.activemq.transaction.demo2;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;

/**
 * Created by cqs on 16-11-28.
 */

public class JmsTemplateHelper {
    private ConnectionFactory connectionFactory;

    private JmsTemplate template;

    private JmsTemplate newJmsTemplate(String queueName) {
        template = new JmsTemplate();
        template.setDefaultDestinationName(queueName);
        template.setDeliveryMode(DeliveryMode.PERSISTENT);
        template.setDeliveryPersistent(true);
        template.setConnectionFactory(connectionFactory);
        template.setSessionTransacted(true);//开启事物
        template.setPubSubDomain(false);
        return template;
    }

    private JmsTemplate newJmsTemplate() {
        return newJmsTemplate("t1");
    }
}
