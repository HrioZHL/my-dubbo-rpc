package com.hrio.rpc.proxy;

import com.hrio.rpc.RegisterType;
import com.hrio.rpc.api.entity.Invocation;
import com.hrio.rpc.api.entity.URL;
import com.hrio.rpc.factory.RemoteRegisterFactory;
import com.hrio.rpc.protocol.dubbo.NettyProtocol;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getProxy(Class interfaceClass) {

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                URL url = RemoteRegisterFactory.getRemoteRegister(RegisterType.LOCAL).getRandomUrl(interfaceClass.getName());
//                HttpProtocol httpProtocol = new HttpProtocol();
//                String result = (String) httpProtocol.invokeProtocol(url, invocation);
                NettyProtocol nettyProtocol = new NettyProtocol();
                String result = (String) nettyProtocol.invokeProtocol(url, invocation);
                return result;
            }
        });
    }
}
