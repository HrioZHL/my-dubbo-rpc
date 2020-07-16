package com.hrio.dubbo_spi.impl;

import com.hrio.dubbo_spi.api.Car;
import com.hrio.dubbo_spi.api.Driver;
import org.apache.dubbo.common.URL;

public class Trucker implements Driver {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    /**
     *
     * @param url 在Dubbo中代表总线的概念
     */
    @Override
    public void driverCar(URL url) {
        // 直接使用car的话，具体引用的是哪个实例不明确，car依赖的是哪个实现类不明确
        car.getColor(url);
    }
}
