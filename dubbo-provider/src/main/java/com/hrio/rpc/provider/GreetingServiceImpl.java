package com.hrio.rpc.provider;

import com.hrio.rpc.api.GreetingService;

/**
 * 实现类
 */
public class GreetingServiceImpl implements GreetingService {

    public String sayHello(String name) {
        System.out.println("hello" + name);
        return "hello" + name;
    }
}
