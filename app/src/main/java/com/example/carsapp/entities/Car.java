package com.example.carsapp.entities;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Car extends RealmObject {

    @PrimaryKey
    private String id;

    private Integer year;

    private Integer price;

    @LinkingObjects("cars")
    private final RealmResults<CarModel> carModel = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CarModel getCarModel() {
        return carModel.get(0);
    }


}
