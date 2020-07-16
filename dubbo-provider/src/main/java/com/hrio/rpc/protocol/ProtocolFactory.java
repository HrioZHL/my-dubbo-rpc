package com.hrio.rpc.protocol;

import com.hrio.rpc.protocol.dubbo.NettyProtocol;
import com.hrio.rpc.protocol.http.HttpProtocol;

public class ProtocolFactory {
    private static HttpProtocol httpProtocol = new HttpProtocol();
    private static NettyProtocol nettyProtocol = new NettyProtocol();

    public static Protocol getProtocol(ProtocolType protocolType) {
        switch (protocolType) {
            case HTTP:
                return httpProtocol;
            case NETTY:
                return nettyProtocol;
            default:
                return null;
        }
    }
}
