package com.cqs.activemq.topic

import com.cqs.commons.util.ContextUtils
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by cqs on 11/7/16.
 */
class TopicClient {
    private static ClassPathXmlApplicationContext context = ContextUtils.getClassPathXmlApplicationContext();


    private def newArticle() {
        def article = new Article();
        article.setAuthor("张三")
        article.setTitle("论脸皮厚的重要性")
        article.setContent("巴拉巴拉")
        article.setCreateDate(new Date())
        article.setPublishDate(new Date())
        return article
    }

    public static void main(String[] args) {
        Reader reader = context.getBean(Reader.class)
        println reader
        def client = new TopicClient()
        def writer = context.getBean(Writer.class);
        def article = client.newArticle()
        writer.writeArticle(article)

        writer.publishArticle()


        context.close()

    }
}
