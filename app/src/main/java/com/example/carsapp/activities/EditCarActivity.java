package com.example.carsapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;


import com.example.carsapp.R;
import com.example.carsapp.adapters.BrandSpinnerAdapter;
import com.example.carsapp.adapters.CarDataAdapter;
import com.example.carsapp.adapters.CarModelSpinnerAdapter;
import com.example.carsapp.db_helpers.CarsDBHelper;
import com.example.carsapp.entities.Brand;
import com.example.carsapp.entities.Car;
import com.example.carsapp.entities.CarModel;

import java.util.ArrayList;

import io.realm.Realm;
public class EditCarActivity extends AppCompatActivity {

    ArrayList<Brand> brandsList;
    ArrayList<CarModel> modelsList;

    private Spinner brandsSpinner;
    private BrandSpinnerAdapter brandsAdapter;

    private Spinner carModelsSpinner;
    private CarModelSpinnerAdapter carModelsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);

        EditText priceInput = (EditText) findViewById(R.id.price_input);
        EditText yearInput = (EditText) findViewById(R.id.year_input);
        TextView textView = (TextView) findViewById(R.id.car_title);

        Realm realm = Realm.getDefaultInstance();
//        todo add new car
//        brandsList = new ArrayList(realm.where(Brand.class).findAll());
//        modelsList = new ArrayList(realm.where(CarModel.class).findAll());
//
//        setBrandsAdapterToSpinner();
//        setCarModelsAdapterToSpinner();

        String carId = getIntent().getStringExtra("CAR_ID");

        Car realmCar = realm.where(Car.class).equalTo("id", carId).findFirst();

        priceInput.setText(String.valueOf(realmCar.getPrice()), TextView.BufferType.EDITABLE);
        yearInput.setText(String.valueOf(realmCar.getYear()), TextView.BufferType.EDITABLE);

        textView.setText(realmCar.getCarModel().getModelBrand().getName() + " " + realmCar.getCarModel().getModelName());

        FloatingActionButton fab = findViewById(R.id.fab_save);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                yearInput.getText();

                CarsDBHelper dbHelper = new CarsDBHelper();
                dbHelper.editCar(carId,
                        yearInput.getText().toString(),
                        priceInput.getText().toString());

                finish();
            }
        });

    }

    private void setCarModelsAdapterToSpinner() {
        carModelsAdapter = new CarModelSpinnerAdapter(EditCarActivity.this,
                android.R.layout.simple_spinner_item,
                modelsList);
//        carModelsSpinner =  findViewById(R.id.model_spinner);
        carModelsSpinner.setAdapter(carModelsAdapter);
        carModelsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                CarModel model = carModelsAdapter.getItem(position);
                Toast.makeText(EditCarActivity.this, "ID: " + model.getId() + "\nName: " + model.getModelName(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
    }

    private void setBrandsAdapterToSpinner() {
        brandsAdapter = new BrandSpinnerAdapter(EditCarActivity.this,
                android.R.layout.simple_spinner_item,
                brandsList);
//        brandsSpinner =  findViewById(R.id.brand_spinner);
        brandsSpinner.setAdapter(brandsAdapter);
        brandsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Brand brand = brandsAdapter.getItem(position);
                Toast.makeText(EditCarActivity.this, "ID: " + brand.getId() + "\nName: " + brand.getName(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
    }
}
