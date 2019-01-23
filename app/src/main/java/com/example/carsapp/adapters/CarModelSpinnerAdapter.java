package com.example.carsapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.carsapp.entities.CarModel;

import java.util.ArrayList;

public class CarModelSpinnerAdapter extends ArrayAdapter<CarModel> {

    private ArrayList<CarModel> values;

    public CarModelSpinnerAdapter(Context context, int textViewResourceId,
                               ArrayList<CarModel> values) {
        super(context, textViewResourceId, values);
        this.values = values;
    }

    @Override
    public int getCount(){
        return values.size();
    }

    @Override
    public CarModel getItem(int position){
        return values.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values.get(position).getModelName());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values.get(position).getModelName());

        return label;
    }
}