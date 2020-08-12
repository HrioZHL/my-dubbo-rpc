package com.hrio.rpc.protocol;

/**
 * 服务段Server
 */
public interface RpcServer {

    /**
     * 开启服务 监听hostName:port
     * @param hostName
     * @param port
     */
    void start(String hostName, int port);
}
