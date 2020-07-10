package com.hrio.rpc.consumer;


import com.hrio.rpc.api.GreetingService;
import com.hrio.rpc.api.entity.Invocation;
import com.hrio.rpc.protocol.http.client.HttpClient;

public class ConsumerStarter {
    public static void main(String[] args) {

        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(GreetingService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"World"});
        String result = httpClient.post("localhost", 8080, invocation);
        System.out.println(result);

    }
}
