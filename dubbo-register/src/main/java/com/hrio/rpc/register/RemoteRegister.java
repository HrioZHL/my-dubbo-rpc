package com.hrio.rpc.register;

import com.hrio.rpc.api.entity.URL;

/**
 * 消费者端根据服务名字找对应的地址发起远程调用
 */
public interface RemoteRegister {

    /**
     * 注册到远程注册中心
     * @param interfaceName
     * @param url
     */
    void register(String interfaceName, URL url);

    /**
     * 根据服务名获取服务提供者的地址信息
     * @param interfaceName
     * @return
     */
    URL getRandomUrl(String interfaceName);
}
