package com.example.carsapp.pojo;

import java.math.BigInteger;

public class Car {
    private String model;
    private BigInteger price;

    public Car(String model, BigInteger price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }
}
