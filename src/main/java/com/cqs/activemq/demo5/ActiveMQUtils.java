package com.cqs.activemq.demo5;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;

class ActiveMQUtils {
    public final static String USER = "admin";
    public final static String PASSWORD = "admin";
    public final static String URL = "tcp://localhost:61616";
    public final static ConnectionFactory factory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);

    public static ConnectionFactory getConnectFactory() {
        return factory;
    }

}