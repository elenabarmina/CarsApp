package com.example.carsapp.enums;

import android.graphics.Color;

import com.example.carsapp.R;

public enum SwipeCarButtons {
    NONE (0, "", 0),
    EDIT (Color.DKGRAY, "EDIT", 0),
    DELETE (Color.RED, "DELETE", R.mipmap.ic_launcher);

    private Integer color;
    private String text;
    private int icon;

    SwipeCarButtons(int color, String text, int iconPath){
        this.color = color;
        this.text = text;
        this.icon = iconPath;
    }

    public Integer getColor(){
        return this.color;
    }

    public String getText(){
        return this.text;
    }

    public int getIconId(){
        return this.icon;
    }
}
