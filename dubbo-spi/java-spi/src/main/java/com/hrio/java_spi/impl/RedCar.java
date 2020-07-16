package com.hrio.java_spi.impl;

import com.hrio.java_spi.api.CarInterface;

public class RedCar implements CarInterface {
    @Override
    public void getColor() {
        System.out.println("Red!!!");
    }
}
