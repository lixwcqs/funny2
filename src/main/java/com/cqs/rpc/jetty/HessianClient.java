package com.cqs.rpc.jetty;


import com.caucho.hessian.client.HessianProxyFactory;

public class HessianClient {

    public static void main(String[] args) throws Exception {
        HessianProxyFactory factory = new HessianProxyFactory();
        Basic basic = (Basic) factory.create(Basic.class,
                "http://localhost:8080/test");
        System.out.println("Hello: " + basic.hello());
        System.out.println("Hello: " + basic.hello2());

    }

}