package com.cqs.activemq.demo2;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by cloud on 16-11-5.
 */
public class MessageConsumer implements MessageListener{



    public void work() throws JMSException {
        Connection connection = ActiveMQUtils.getConnectFactory().createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("f1");
        javax.jms.MessageConsumer consumer = session.createConsumer(queue);

        Message message = consumer.receive(10000);
        System.out.println(message);

        session.close();
        connection.close();
    }


    public void onMessage(Message message) {
    }

    public static void main(String[] args) throws JMSException {
        new MessageConsumer().work();
    }
}

class ActiveMQUtils{
    public final static String USER = "admin";
    public final static String PASSWORD = "admin";
    public final static String URL = "tcp://localhost:61616";
    public final static ConnectionFactory factory =  new ActiveMQConnectionFactory(USER,PASSWORD,URL);

    public static ConnectionFactory getConnectFactory(){
        return factory;
    }

}
