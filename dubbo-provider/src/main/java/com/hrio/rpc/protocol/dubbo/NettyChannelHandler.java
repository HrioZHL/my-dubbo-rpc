package com.hrio.rpc.protocol.dubbo;

import com.hrio.rpc.RegisterType;
import com.hrio.rpc.api.entity.Invocation;
import com.hrio.rpc.factory.LocalRegisterFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;


public class NettyChannelHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation) msg;
        String interfaceName = invocation.getInterfaceName();
        Class interfaceImplClass = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL).get(interfaceName);
        Method method = interfaceImplClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        String result = (String) method.invoke(interfaceImplClass.newInstance(), invocation.getParams());
        ctx.write(result);
        ctx.flush();
    }
}
