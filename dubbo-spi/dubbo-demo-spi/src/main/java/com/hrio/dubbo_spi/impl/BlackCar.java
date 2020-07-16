package com.hrio.dubbo_spi.impl;

import com.hrio.dubbo_spi.api.Car;
import org.apache.dubbo.common.URL;

public class BlackCar implements Car {
    @Override
    public void getColor(URL url) {
        System.out.println("Black!!!");
    }
}
