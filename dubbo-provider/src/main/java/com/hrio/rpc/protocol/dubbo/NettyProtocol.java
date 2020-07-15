package com.hrio.rpc.protocol.dubbo;


import com.hrio.rpc.api.entity.Invocation;
import com.hrio.rpc.api.entity.URL;
import com.hrio.rpc.protocol.Protocol;
import com.hrio.rpc.protocol.dubbo.client.NettyClient;

public class NettyProtocol implements Protocol {

    @Override
    public Object invokeProtocol(URL url, Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHostname(), url.getPort(), invocation);
    }

    @Override
    public void start(URL url) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(url.getHostname(), url.getPort());
    }
}
