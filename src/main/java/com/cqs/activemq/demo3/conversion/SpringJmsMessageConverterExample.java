package com.cqs.activemq.demo3.conversion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsMessageConverterExample {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        try {
            SpringJmsPersonProducer springJmsProducer = context.getBean(SpringJmsPersonProducer.class);
            Person joe = new Person("Joe", 32);
            System.out.println("Sending person " + joe);
            springJmsProducer.sendMessage(joe);
            SpringJmsPersonConsumer springJmsConsumer = context.getBean(SpringJmsPersonConsumer.class);
            System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
        } finally {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
}