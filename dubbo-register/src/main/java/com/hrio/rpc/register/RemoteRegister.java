package com.hrio.rpc.register;

import com.hrio.rpc.api.entity.URL;

import java.util.*;

public class RemoteRegister {
    private static Map<String, List<URL>> registerMap = new HashMap<>();

    public static void register(String interfaceName, URL url) {
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
    }
}
