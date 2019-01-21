package com.example.carsapp.activities;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.carsapp.R;
import com.example.carsapp.adapters.CarDataAdapter;
import com.example.carsapp.controllers.SwipeController;
import com.example.carsapp.controllers.SwipeControllerActions;
import com.example.carsapp.pojo.Car;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CarDataAdapter carAdapter;
    SwipeController swipeController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCarDataAdapter();
        setupRecyclerView();
    }

    private void setCarDataAdapter() {
        List<Car> carsList = new ArrayList<>();

        carsList.add(new Car("Toyota", BigInteger.valueOf(15000L)));
        carsList.add(new Car("Nissan", BigInteger.valueOf(20000L)));

        carAdapter = new CarDataAdapter(carsList);

    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(carAdapter);

        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                carAdapter.removeCarByPosition(position);
                carAdapter.notifyItemRemoved(position);
                carAdapter.notifyItemRangeChanged(position, carAdapter.getItemCount());
            }
        }, getResources());

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }

}