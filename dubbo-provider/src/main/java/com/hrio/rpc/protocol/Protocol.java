package com.hrio.rpc.protocol;

import com.hrio.rpc.api.entity.Invocation;
import com.hrio.rpc.api.entity.URL;

public interface Protocol {

    /**
     * 服务开启
     * @param url
     */
    void start(URL url);

    /**
     * 远程调用
     * @param url
     * @param invocation
     * @return
     */
    Object invokeProtocol(URL url, Invocation invocation);
}
