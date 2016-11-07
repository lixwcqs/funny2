package com.cqs.commons.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cqs on 11/7/16.
 */
public class ContextUtils {
    private final static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    public static ClassPathXmlApplicationContext getClassPathXmlApplicationContext() {
        return context;
    }

}
