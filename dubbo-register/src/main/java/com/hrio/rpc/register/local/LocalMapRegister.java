package com.hrio.rpc.register.local;

import com.hrio.rpc.register.LocalRegister;

import java.util.HashMap;
import java.util.Map;

public class LocalMapRegister implements LocalRegister {
    private static Map<String, Class> map = new HashMap<>();

    public void register(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
