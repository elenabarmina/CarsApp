package com.example.carsapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carsapp.R;
import com.example.carsapp.entities.Car;

import java.util.List;

public class CarDataAdapter extends
        RecyclerView.Adapter<CarDataAdapter.CarViewHolder>{

    private List<Car> cars;

    public void removeCarByPosition(int position){
        cars.remove(position);
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        private TextView model, price;

        public CarViewHolder(View view) {
            super(view);
            model = (TextView) view.findViewById(R.id.car_name);
            price = (TextView) view.findViewById(R.id.price);
        }
    }

    public CarDataAdapter(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_row, parent, false);

        return new CarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car car = cars.get(position);

        StringBuilder sbCarName = new StringBuilder();
        sbCarName.append(car.getCarModel().getModelBrand().getName())
                .append(" ")
                .append(car.getCarModel().getModelName());

        holder.model.setText(sbCarName.toString());
        holder.price.setText(car.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

}
