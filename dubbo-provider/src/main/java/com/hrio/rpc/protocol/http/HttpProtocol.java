package com.hrio.rpc.protocol.http;

import com.hrio.rpc.api.entity.Invocation;
import com.hrio.rpc.api.entity.URL;
import com.hrio.rpc.protocol.Protocol;
import com.hrio.rpc.protocol.http.client.HttpClient;

public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());
    }

    @Override
    public Object invokeProtocol(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.post(url.getHostname(), url.getPort(), invocation);
    }
}
