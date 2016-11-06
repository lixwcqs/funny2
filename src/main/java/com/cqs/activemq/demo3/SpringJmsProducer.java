package com.cqs.activemq.demo3;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringJmsProducer {
    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination destination;

    @Resource(name = "destination2")
    private Destination destination2;

    public void sendMessage(final String msg) {
        System.out.println(destination + "\t" + destination2);
        System.out.println("Producer sends " + msg);
        jmsTemplate.send(destination, (session) -> {
            return session.createTextMessage(msg);
        });

        jmsTemplate.send(destination2, (session) -> {
            return session.createTextMessage(msg);
        });

        List<Destination> destinations = new ArrayList<>();
        destinations.add(new ActiveMQQueue("dest3"));
        destinations.add(new ActiveMQQueue("dest4"));
        destinations.add(new ActiveMQQueue("dest5"));
        for (Destination dest : destinations) {
            jmsTemplate.send(dest, (session -> {
                return session.createTextMessage("hello word" + dest.toString());
            }));
        }

    }
}