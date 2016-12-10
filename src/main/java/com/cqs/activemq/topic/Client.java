package com.cqs.activemq.topic;

import com.cqs.commons.util.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cqs on 11/8/16.
 */
public class Client {
    private static ClassPathXmlApplicationContext context = ContextUtils.getClassPathXmlApplicationContext();

    public static void main(String[] args) {
        Utils utils = context.getBean(Utils.class);
        System.out.println(utils.destination);
        //context.getBean(org.springframework.jms.listener.DefaultMessageListenerContainer.class);
        System.out.println(utils.connectionFactory);
        ExecutorService service = Executors.newSingleThreadExecutor();
        Writer writer = context.getBean(Writer.class);
        writer.writeArticle(TopicClient.newArticle());
        service.submit(() -> {
                    for (int i = 0; i < 10; ++i) {
                        writer.publishArticle();
                    }
                }
        );

        service.shutdown();
        context.close();
    }
}

@Component
class Utils {

    @Autowired
    @Qualifier("articleQueue")
    Destination destination;


    @Resource
    @Qualifier("connectionFactory")
    ConnectionFactory connectionFactory;
}
