package com.example.carsapp;

import android.app.Application;

import com.example.carsapp.entities.Brand;
import com.example.carsapp.entities.Car;
import com.example.carsapp.entities.CarModel;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CarsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("carsdb.realm").build();
        Realm.setDefaultConfiguration(config);
//
//        Realm realm = Realm.getDefaultInstance();
//
//        realm.beginTransaction();
//
//        Brand ralmBrand = realm.createObject(Brand.class, UUID.randomUUID().toString());
//        ralmBrand.setName("Peugeot");
//
//        CarModel realmCarModel = realm.createObject(CarModel.class, UUID.randomUUID().toString());
//        realmCarModel.setModelName("308");
//        ralmBrand.addModel(realmCarModel);
//        Car realmCar = realm.createObject(Car.class, UUID.randomUUID().toString());
//        realmCar.setPrice(8000);
//        realmCar.setYear(2008);
//        realmCarModel.addCarl(realmCar);
//
//        CarModel realmCarModel2 = realm.createObject(CarModel.class, UUID.randomUUID().toString());
//        realmCarModel2.setModelName("Teppe");
//        ralmBrand.addModel(realmCarModel2);
//        Car realmCar2 = realm.createObject(Car.class, UUID.randomUUID().toString());
//        realmCar2.setPrice(99000);
//        realmCar2.setYear(2018);
//        realmCarModel2.addCarl(realmCar2);
//
//        Brand ralmBrand2 = realm.createObject(Brand.class, UUID.randomUUID().toString());
//        ralmBrand2.setName("Chevrolet");
//
//        CarModel realmCarModel3 = realm.createObject(CarModel.class, UUID.randomUUID().toString());
//        realmCarModel3.setModelName("Aveo");
//        ralmBrand2.addModel(realmCarModel3);
//        Car realmCar3 = realm.createObject(Car.class, UUID.randomUUID().toString());
//        realmCar3.setPrice(60000);
//        realmCar3.setYear(2012);
//        realmCarModel3.addCarl(realmCar3);
//
//        CarModel realmCarModel4 = realm.createObject(CarModel.class, UUID.randomUUID().toString());
//        realmCarModel4.setModelName("Camaro");
//        ralmBrand2.addModel(realmCarModel4);
//        Car realmCar4 = realm.createObject(Car.class, UUID.randomUUID().toString());
//        realmCar4.setPrice(880000);
//        realmCar4.setYear(2015);
//        realmCarModel4.addCarl(realmCar4);
//
//        CarModel realmCarModel5 = realm.createObject(CarModel.class, UUID.randomUUID().toString());
//        realmCarModel5.setModelName("Tahoe");
//        ralmBrand2.addModel(realmCarModel5);
//        Car realmCar5 = realm.createObject(Car.class, UUID.randomUUID().toString());
//        realmCar5.setPrice(990000);
//        realmCar5.setYear(2016);
//        realmCarModel5.addCarl(realmCar5);
//
//        realm.commitTransaction();
//        realm.close();
    }
}
