package com.hrio.rpc.protocol.http;

import com.hrio.rpc.RegisterType;
import com.hrio.rpc.api.entity.Invocation;
import com.hrio.rpc.factory.LocalRegisterFactory;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        // 处理请求，返回结果，也就是执行服务
        try {
            // 1.从请求中拿出Invocation对象
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);//从流中获取数据
            Invocation invocation = (Invocation) objectInputStream.readObject();//从流中读取数据反序列话成实体类

            // 2.从Invocation对象中拿出实现类、方法、参数类型列表和参数列表

            String interfaceName = invocation.getInterfaceName();
            Class implClass = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL).get(interfaceName);// 从本地注册中拿出实现类

            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());// 拿出method对象

            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());// 通过反射执行方法，由于知道实现类返回String，所以先强转成String

            IOUtils.write(result, resp.getOutputStream());// 把result返回给HttpClient
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
