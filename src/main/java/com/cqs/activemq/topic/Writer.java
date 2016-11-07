package com.cqs.activemq.topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by cqs on 11/7/16.
 */
@Component
public class Writer {

    @Resource
    private JmsTemplate jmsTemplate;
    //
    @Autowired
    @Qualifier("articleQueue")
    private Destination destination;

    private Article article;

    public void writeArticle(Article article) {
        System.out.println("发送者：写了一篇新的文章");
        this.article = article;
    }

    public void publishArticle() {
        Assert.notNull(article);
        jmsTemplate.send(destination, (session) -> {
            return session.createTextMessage(article.getTitle());
        });
    }
}