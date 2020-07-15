package com.hrio.rpc.factory;

import com.hrio.rpc.RegisterType;
import com.hrio.rpc.register.RemoteRegister;
import com.hrio.rpc.register.local.RemoteMapRegister;

public class RemoteRegisterFactory {
    private static RemoteMapRegister remoteMapRegister = new RemoteMapRegister();

    public static RemoteRegister getRemoteRegister(RegisterType registerType) {
        switch (registerType) {
            case LOCAL:
                return remoteMapRegister;
            default:
                return null;
        }
    }
}
