package com.cqs.activemq.transaction.demo2;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

/**
 * Created by cqs on 16-11-29.
 */
@Component
public class JmsErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
