package com.example.carsapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CarsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("carsdb.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}
