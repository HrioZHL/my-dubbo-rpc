package com.hrio.dubbo_spi.impl;

import com.hrio.dubbo_spi.api.Car;

public class RedCar implements Car {
    @Override
    public void getColor() {
        System.out.println("Red!!!");
    }
}
