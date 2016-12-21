package com.yingjun.ssm.web;

import com.caucho.hessian.client.HessianProxyFactory;
import org.junit.Test;

/**
 * Created by cqs on 16-12-14.
 */
public class IUserControllerTest {
    @Test
    public void list() throws Exception {
        String url = "http://localhost:8080/user/list";

        HessianProxyFactory factory = new HessianProxyFactory();
        IUserController basic = (IUserController) factory.create(IUserController.class, url);

        System.out.println("hello(): " + basic.list(null, 1, 1));
    }

}