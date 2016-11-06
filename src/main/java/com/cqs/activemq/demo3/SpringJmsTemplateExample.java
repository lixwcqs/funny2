package com.cqs.activemq.demo3;

import java.net.URISyntaxException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsTemplateExample {
    public static void main(String[] args) throws URISyntaxException, Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");

        try {
            SpringJmsProducer springJmsProducer = context.getBean(SpringJmsProducer.class);
            springJmsProducer.sendMessage("SomeTask");

            SpringJmsConsumer springJmsConsumer = context.getBean(SpringJmsConsumer.class);
            System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
        } finally {
            context.close();
        }
    }
}