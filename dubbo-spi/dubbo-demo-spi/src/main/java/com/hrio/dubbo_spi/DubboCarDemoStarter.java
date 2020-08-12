package com.hrio.dubbo_spi;

import com.hrio.dubbo_spi.api.Car;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboCarDemoStarter {
    public static void main(String[] args) {
        // 每个接口对应一个ExtensionLoader扩展加载器
        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
        Car redCar = extensionLoader.getExtension("red"); //name如果传true的话，则使用默认的实现类
        redCar.getColor(null);
//        Car blackCar = extensionLoader.getExtension("black");
//        blackCar.getColor();
    }
}
