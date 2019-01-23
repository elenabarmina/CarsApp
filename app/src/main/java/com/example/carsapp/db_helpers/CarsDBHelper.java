package com.example.carsapp.db_helpers;

import com.example.carsapp.entities.Car;
import com.example.carsapp.entities.CarModel;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class CarsDBHelper {

    public void addCar(String carModelId, String year, String price) {

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        CarModel realmCarModel = realm.where(CarModel.class).equalTo("id", carModelId).findFirst();

        Car realmCar = realm.createObject(Car.class, UUID.randomUUID().toString());
        realmCar.setPrice(Integer.getInteger(price));
        realmCar.setYear(Integer.getInteger(year));

        realmCarModel.addCarl(realmCar);

        realm.commitTransaction();
        realm.close();
    }

    public void editCar(String carId, String year, String price) {

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        Car realmCar = realm.where(Car.class).equalTo("id", carId).findFirst();
        realmCar.setPrice(Integer.valueOf(price));
        realmCar.setYear(Integer.valueOf(year));

        realm.commitTransaction();
        realm.close();
    }

    public void deleteCar(int position) {

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Car> carList = realm.where(Car.class).findAll();

        realm.beginTransaction();

        Car realmCar = realm.where(Car.class).equalTo("id", carList.get(position).getId()).findFirst();
        realmCar.deleteFromRealm();

        realm.commitTransaction();
        realm.close();
    }

    public String getCarIdByPosition(int position) {

        String result = "";

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Car> carList = realm.where(Car.class).findAll();
        realm.beginTransaction();

        result = carList.get(position).getId();

        realm.commitTransaction();
        realm.close();

        return result;
    }

}
