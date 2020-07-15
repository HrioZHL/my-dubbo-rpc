package com.hrio.rpc.register.local;

import com.hrio.rpc.api.entity.URL;
import com.hrio.rpc.register.RemoteRegister;

import java.io.*;
import java.util.*;

public class RemoteMapRegister implements RemoteRegister {
    private static Map<String, List<URL>> registerMap = new HashMap<>();
    public static final String path = "/Users/hrio/Documents/Study/GitHub/my-dubbo-rpc/register.txt";

    public void register(String interfaceName, URL url) {
//        List<URL> list = Collections.singletonList(url);
//        registerMap.put(interfaceName, list);
        if (registerMap.containsKey(interfaceName)) {
            List<URL> list = registerMap.get(interfaceName);
            list.add(url);
        } else {
            List<URL> list = new LinkedList<>();
            list.add(url);
            registerMap.put(interfaceName, list);
        }
        try {
            saveFile(path, registerMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从Register中随机获取url（负载均衡）
     *
     * @param interfaceName
     * @return
     */
    public URL getRandomUrl(String interfaceName) {
        try {
            registerMap = (Map<String, List<URL>>) readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 直接使用Map读取会有问题 因为服务提供者和服务消费者属于两个进程，无法共享registerMap，所以要用文件共享解决。
        List<URL> list = registerMap.get(interfaceName);
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }

    /**
     * 写入文件
     *
     * @param path
     * @param object
     * @throws IOException
     */
    public void saveFile(String path, Object object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
    }

    /**
     * 读取文件
     *
     * @param path
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private Object readFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }


}
