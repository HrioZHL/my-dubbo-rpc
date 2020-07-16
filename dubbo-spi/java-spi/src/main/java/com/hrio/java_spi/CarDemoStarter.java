package com.hrio.java_spi;

import com.hrio.java_spi.api.CarInterface;

import java.util.Iterator;
import java.util.ServiceLoader;

public class CarDemoStarter {
    public static void main(String[] args) {
        ServiceLoader<CarInterface> serviceLoader = ServiceLoader.load(CarInterface.class);
        Iterator<CarInterface> iterator = serviceLoader.iterator();
        //Java SPI不能单独获取某个指定的实现类
        //Java SPI没有IOC和AOP机制
        while (iterator.hasNext()) {
            CarInterface carInterface = iterator.next();
            carInterface.getColor();
        }
    }
}
