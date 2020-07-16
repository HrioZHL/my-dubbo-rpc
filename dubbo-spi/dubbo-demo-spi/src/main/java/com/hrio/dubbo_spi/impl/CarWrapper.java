package com.hrio.dubbo_spi.impl;

import com.hrio.dubbo_spi.api.Car;

/**
 * 包装类
 */
public class CarWrapper implements Car {

    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    @Override
    public void getColor() {
        System.out.println("Before...");
        car.getColor();
        System.out.println("After...");
    }
}
