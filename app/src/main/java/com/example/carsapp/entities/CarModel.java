package com.example.carsapp.entities;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class CarModel extends RealmObject {

    @PrimaryKey
    private String id;

    private String modelName;

    @LinkingObjects("carModels")
    private final RealmResults<Brand> modelBrand = null;

    private RealmList<Car> cars;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Brand getModelBrand() {
        return modelBrand.get(0);
    }

    public void addCarl(Car car){
        cars.add(car);
    }

    public void deleteModelByIndex(Integer index){
        cars.remove(index);
    }
}
