package com.example.carsapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;


import com.example.carsapp.R;
import com.example.carsapp.adapters.CarModelSpinnerAdapter;
import com.example.carsapp.db_helpers.CarsDBHelper;
import com.example.carsapp.entities.Car;
import com.example.carsapp.entities.CarModel;

import java.util.ArrayList;

import io.realm.Realm;
public class EditCarActivity extends AppCompatActivity {

    ArrayList<CarModel> modelsList;

    private Spinner carModelsSpinner;
    private CarModelSpinnerAdapter carModelsAdapter;
    private String carModelSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);

        EditText priceInput = (EditText) findViewById(R.id.price_input);
        EditText yearInput = (EditText) findViewById(R.id.year_input);
        TextView textView = (TextView) findViewById(R.id.car_title);

        Realm realm = Realm.getDefaultInstance();

        modelsList = new ArrayList(realm.where(CarModel.class).findAll());
        setCarModelsAdapterToSpinner();

        String carId = getIntent().getStringExtra("CAR_ID");

        if (carId.equals("-1"))
        {
            carModelsSpinner.setVisibility(View.VISIBLE);
            FloatingActionButton fab = findViewById(R.id.fab_save);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CarsDBHelper dbHelper = new CarsDBHelper();
                    dbHelper.addCar(carModelSelected,
                            yearInput.getText().toString(),
                            priceInput.getText().toString());

                    finish();
                }
            });
        } else {
            carModelsSpinner.setVisibility(View.GONE);
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
    }

    private void setCarModelsAdapterToSpinner() {
        carModelsAdapter = new CarModelSpinnerAdapter(EditCarActivity.this,
                android.R.layout.simple_spinner_item,
                modelsList);
        carModelsSpinner =  findViewById(R.id.model_spinner);
        carModelsSpinner.setAdapter(carModelsAdapter);
        carModelsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                CarModel model = carModelsAdapter.getItem(position);
                carModelSelected = model.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
                CarModel model = carModelsAdapter.getItem(0);
                carModelSelected = model.getId();
            }
        });
    }
}
