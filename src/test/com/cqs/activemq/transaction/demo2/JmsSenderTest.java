package com.cqs.activemq.transaction.demo2;

import com.cqs.com.cqs.BaseTestConfiguration;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by cqs on 16-11-28.
 */
public class JmsSenderTest extends BaseTestConfiguration {
    @Resource
    JmsSender sender;

    @org.junit.Test
    public void sendMessage() throws Exception {
        sender.sendMessage();
        TimeUnit.SECONDS.sleep(2);
    }

}