package com.cqs.activemq.topic

import com.cqs.commons.util.ContextUtils
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.jms.listener.MessageListenerContainer

/**
 * Created by cqs on 11/7/16.
 */
class TopicClient {

    private static ClassPathXmlApplicationContext context = ContextUtils.getClassPathXmlApplicationContext()


    public static Article newArticle() {
        def article = new Article();
        article.setAuthor("张三")
        article.setTitle("论脸皮厚的重要性")
        article.setContent("巴拉巴拉")
        article.setCreateDate(new Date())
        article.setPublishDate(new Date())
        return article
    }

    public static void main(String[] args) {
        def client = new TopicClient()
        def writer = context.getBean(Writer.class);
        def article = newArticle()
        writer.writeArticle(article)
        new Thread({
            100.times {
                writer.publishArticle()
            }
        }).start()

        Utils utils = context.getBean(Utils.class)
        println utils.destination


        new Thread({
            def i = 0;
            10.times {
                MessageListenerContainer container = context.getBean(org.springframework.jms.listener.DefaultMessageListenerContainer.class)
                container.setDestination(utils.destination)
                container.setConnectionFactory(utils.connectionFactory)
                container.setMessageListener(context.getBean(Reader.class, ++i))
            }
        }).start()

//        context.close()

    }
}


