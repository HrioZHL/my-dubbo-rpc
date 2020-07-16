package com.hrio.dubbo_spi.impl;

import com.hrio.dubbo_spi.api.Car;

public class BlackCar implements Car {
    @Override
    public void getColor() {
        System.out.println("Black!!!");
    }
}
