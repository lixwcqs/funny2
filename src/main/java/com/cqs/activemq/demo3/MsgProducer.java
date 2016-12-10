package com.cqs.activemq.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by cloud on 16-11-5.
 */
@Component
public class MsgProducer {
    @Resource
    private JmsTemplate jmsTemplate;


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MsgProducer producer = context.getBean(MsgProducer.class);

        System.out.println(producer);
        System.out.println(producer.jmsTemplate);
    }
}
