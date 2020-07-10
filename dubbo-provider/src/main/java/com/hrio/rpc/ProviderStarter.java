package com.hrio.rpc;

import com.hrio.rpc.api.GreetingService;
import com.hrio.rpc.api.entity.URL;
import com.hrio.rpc.protocol.http.HttpServer;
import com.hrio.rpc.provider.GreetingServiceImpl;
import com.hrio.rpc.register.LocalRegister;
import com.hrio.rpc.register.RemoteRegister;

public class ProviderStarter {
    public static void main(String[] args) {

        // 1.本地注册
        // (服务名、实现类)存到Map里
        LocalRegister.register(GreetingService.class.getName(), GreetingServiceImpl.class);

        // 2.远程注册
        // (服务名、List<URL>)
        URL url = new URL("localhost", 8080);
        RemoteRegister.register(GreetingService.class.getName(), url);

        // 3.启动Tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);

    }
}
