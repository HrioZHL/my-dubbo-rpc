package com.hrio.rpc.protocol;

import com.hrio.rpc.protocol.dubbo.NettyProtocol;
import com.hrio.rpc.protocol.http.HttpProtocol;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ProtocolFactory {
    private static HttpProtocol httpProtocol = new HttpProtocol();
    private static NettyProtocol nettyProtocol = new NettyProtocol();

    public static Protocol getProtocol(ProtocolType protocolType) {
        // 工厂模式
        return getProtocolBySPI();
    }

    public static Protocol getProtocolByType(ProtocolType protocolType) {
        switch (protocolType) {
            case HTTP:
                return httpProtocol;
            case NETTY:
                return nettyProtocol;
            default:
                return null;
        }
    }

    public static Protocol getProtocolBySPI() {
        //Java SPI机制
        ServiceLoader<Protocol> serviceLoader = ServiceLoader.load(Protocol.class);
        Iterator<Protocol> iterator = serviceLoader.iterator();
        return iterator.next();// 只能返回一个协议？所以Dubbo实现了自己的SPI机制

        //Java SPI
        //1.不能单独的获取某个指定的实现类
        //2.没有IOC和AOP机制
    }

    public static Protocol getProtocolByVMOptions() {
        //从启动参数中获取 -DprotocolName=http/dubbo
        String protocolName = System.getProperty("protocolName");
        if (protocolName == null || "".equals(protocolName)) protocolName = "http";
        switch (protocolName) {
            case "http":
                return httpProtocol;
            case "dubbo":
                return nettyProtocol;
            default:
                return null;
        }
    }
}
