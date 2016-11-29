package com.cqs.activemq.transaction.demo1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Random;

/**
 * The Supplier synchronously receives the order from the Vendor and
 * randomly responds with either the number ordered, or some lower
 * quantity.
 */
public class Supplier implements Runnable {
    private String url;
    private String user;
    private String password;
    private final String ITEM;
    private final String QUEUE;

    public Supplier(String item, String queue, String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.ITEM = item;
        this.QUEUE = queue;
    }

    public void run() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
        Session session = null;
        Destination orderQueue;
        try {
            Connection connection = connectionFactory.createConnection();

            session = connection.createSession(true, Session.SESSION_TRANSACTED);
            orderQueue = session.createQueue(QUEUE);
            MessageConsumer consumer = session.createConsumer(orderQueue);

            connection.start();

            while (true) {
                Message message = consumer.receive();
                MessageProducer producer = session.createProducer(message.getJMSReplyTo());//回复消息
                MapMessage orderMessage;
                if (message instanceof MapMessage) {
                    orderMessage = (MapMessage) message;//订单信息
                } else {
                    // End of Stream
                    producer.send(session.createMessage());//结束消息
                    session.commit();
                    producer.close();
                    break;
                }


                int quantity = orderMessage.getInt("Quantity");
                System.out.println(ITEM + " Supplier: Vendor ordered " + quantity + " " + orderMessage.getString("Item"));
                ///模拟提供硬盘或者显示器
                MapMessage outMessage = session.createMapMessage();
                outMessage.setInt("VendorOrderNumber", orderMessage.getInt("VendorOrderNumber"));
                outMessage.setString("Item", ITEM);
                quantity = Math.min(orderMessage.getInt("Quantity"), new Random().nextInt(orderMessage.getInt("Quantity") * 10));
                outMessage.setInt("Quantity", quantity);

                producer.send(outMessage);
                /////

                System.out.println(ITEM + " Supplier: Sent " + quantity + " " + ITEM + "(s)");
                session.commit();
                System.out.println(ITEM + " Supplier: committed transaction");
                producer.close();
            }
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "tcp://localhost:61616";
        String user = null;
        String password = null;
        String item = "HardDrive";

        if (args.length >= 1) {
            item = args[0];
        }
        String queue;
        if ("HardDrive".equals(item)) {
            queue = "StorageOrderQueue";
        } else if ("Monitor".equals(item)) {
            queue = "MonitorOrderQueue";
        } else {
            throw new IllegalArgumentException("Item must be either HardDrive or Monitor");
        }

        if (args.length >= 2) {
            url = args[1];
        }

        if (args.length >= 3) {
            user = args[2];
        }

        if (args.length >= 4) {
            password = args[3];
        }

        Supplier s = new Supplier(item, queue, url, user, password);

        new Thread(s, "Supplier " + item).start();
    }
}