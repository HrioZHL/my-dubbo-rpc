package com.hrio.rpc.register;

/**
 * 供服务端自己在反射调用的时候根据服务名称找到对应的实现
 */
public interface LocalRegister {

    /**
     * 注册到本地
     * @param interfaceName 接口名称
     * @param interfaceImplClass 接口实现类
     */
    void register(String interfaceName,Class interfaceImplClass);

    /**
     * 根据接口名获取实现类
     * @param interfaceName 接口名称
     * @return
     */
    Class get(String interfaceName);
}
