package com.example.carsapp.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.carsapp.R;
import com.example.carsapp.adapters.CarDataAdapter;
import com.example.carsapp.controllers.SwipeController;
import com.example.carsapp.controllers.SwipeControllerActions;
import com.example.carsapp.db_helpers.CarsDBHelper;
import com.example.carsapp.entities.Car;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private CarDataAdapter carAdapter;
    SwipeController swipeController = null;
    private Context context;
    public static String INTENT_PARAM_CAR_ID = "CAR_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCarDataAdapter();
        setupRecyclerView();

        context = this;

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //todo add activity
//            }
//        });
    }

    private void setCarDataAdapter() {

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Car> carList = realm.where(Car.class).findAll();

        carAdapter = new CarDataAdapter(carList);

    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(carAdapter);

        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                carAdapter.removeCarByPosition(position);
                carAdapter.notifyItemRemoved(position);
                carAdapter.notifyItemRangeChanged(position, carAdapter.getItemCount());
            }
            @Override
            public void onLeftClicked(int position) {

                CarsDBHelper dbHelper = new CarsDBHelper();

                Intent intent = new Intent(context, EditCarActivity.class);
                intent.putExtra("CAR_ID", dbHelper.getCarIdByPosition(position));

                startActivity(intent);
            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carAdapter.notifyDataSetChanged();
    }

}