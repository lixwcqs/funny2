package com.cqs.activemq.demo2;


import javax.jms.*;

/**
 * Created by cloud on 16-11-5.
 */
public class MessageProducer {

    public void work() throws JMSException {
        ConnectionFactory factory = ActiveMQUtils.getConnectFactory();
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("f1");
        javax.jms.MessageProducer producer = session.createProducer(queue);
        producer.send(session.createTextMessage("Hello world,Activemq"));

        session.close();
        connection.close();

    }


    public static void main(String[] args) throws JMSException {
        new MessageProducer().work();
    }
}
