package com.hrio.rpc.factory;

import com.hrio.rpc.RegisterType;
import com.hrio.rpc.register.LocalRegister;
import com.hrio.rpc.register.local.LocalMapRegister;

public class LocalRegisterFactory {

    private static LocalMapRegister localMapRegister = new LocalMapRegister();

    public static LocalRegister getLocalRegister(RegisterType registerType) {
        switch (registerType) {
            case LOCAL:
                return localMapRegister;
            default:
                return null;
        }
    }
}
