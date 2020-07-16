package com.hrio.java_spi.impl;

import com.hrio.java_spi.api.CarInterface;

public class BlackCar implements CarInterface {
    @Override
    public void getColor() {
        System.out.println("Black!!!");
    }
}
