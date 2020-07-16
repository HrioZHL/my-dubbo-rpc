package com.hrio.dubbo_spi.api;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Car {
    public void getColor();
}
