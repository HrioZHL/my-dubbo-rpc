package com.hrio.dubbo_spi.impl;

import com.hrio.dubbo_spi.api.Car;
import org.apache.dubbo.common.URL;

/**
 * 包装类
 */
public class CarWrapper implements Car {

    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    @Override
    public void getColor(URL url) {
        System.out.println("Before...");
        car.getColor(url);
        System.out.println("After...");
    }
}
