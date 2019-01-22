package com.example.carsapp.db_helpers;

import com.example.carsapp.entities.Car;

import java.util.UUID;

import io.realm.Realm;

public class CarsDBHelper {

    public void addCar(Car car) {

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Car realmCar = realm.createObject(Car.class);

        realmCar.setId(UUID.randomUUID().toString());
        realmCar.setYear(car.getYear());
        realmCar.setPrice(car.getPrice());

        realm.commitTransaction();
        realm.close();
    }

}
