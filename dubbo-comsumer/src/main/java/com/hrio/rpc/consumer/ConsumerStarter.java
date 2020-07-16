package com.hrio.rpc.consumer;


import com.hrio.rpc.api.GreetingService;
import com.hrio.rpc.proxy.ProxyFactory;

public class ConsumerStarter {
    public static void main(String[] args) {
        GreetingService greetingService = ProxyFactory.getProxy(GreetingService.class);
        // 通过代理对象执行方法时会先调用ProxyFactory中的invoke方法处理网络
        System.out.println(greetingService.sayHello("World"));
    }
}
