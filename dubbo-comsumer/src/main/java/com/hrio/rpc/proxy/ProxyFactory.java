package com.hrio.rpc.proxy;

import com.hrio.rpc.api.entity.Invocation;
import com.hrio.rpc.api.entity.URL;
import com.hrio.rpc.protocol.http.client.HttpClient;
import com.hrio.rpc.register.RemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getProxy(Class interfaceClass) {

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                URL url = RemoteRegister.getRandomUrl(interfaceClass.getName());
                String result = httpClient.post(url.getHostname(), url.getPort(), invocation);
                return result;
            }
        });
    }
}
