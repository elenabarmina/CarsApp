package com.example.carsapp.entities;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Brand extends RealmObject {

    @PrimaryKey
    private String id;
    private String name;
    private RealmList<CarModel> carModels = new RealmList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<CarModel> getCarModel() {
        return carModels;
    }

    public void setCarModel(RealmList<CarModel> carModels) {
        this.carModels = carModels;
    }

    public void addModel(CarModel carModel){
        carModels.add(carModel);
    }

    public void deleteModelByIndex(Integer index){
        carModels.remove(index);
    }
}
