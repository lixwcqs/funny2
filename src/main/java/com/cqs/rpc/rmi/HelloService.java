package com.cqs.rpc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 服务接口，封装了供远程调用的方法
 */
public interface HelloService extends Remote {
    // 服务方法
    String sayHello(String name) throws RemoteException;
}