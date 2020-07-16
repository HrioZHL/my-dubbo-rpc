package com.hrio.dubbo_spi;

import com.hrio.dubbo_spi.api.Car;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboCarDemoStarter {
    public static void main(String[] args) {
        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
        Car redCar = extensionLoader.getExtension("red");
        redCar.getColor();
//        Car blackCar = extensionLoader.getExtension("black");
//        blackCar.getColor();
    }
}
