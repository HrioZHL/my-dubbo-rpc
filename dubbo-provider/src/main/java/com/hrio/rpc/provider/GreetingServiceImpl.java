package com.hrio.rpc.provider;

import com.hrio.rpc.api.GreetingService;

/**
 * 实现类
 */
public class GreetingServiceImpl implements GreetingService {

    public String sayHello(String name) {
        System.out.println("Hello " + name);
        return "Hello " + name;
    }
}
