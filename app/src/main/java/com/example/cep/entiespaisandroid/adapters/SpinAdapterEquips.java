package com.example.cep.entiespaisandroid.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.classes.EQUIPS;

import java.util.ArrayList;

public class SpinAdapterEquips extends ArrayAdapter<EQUIPS> {

    private Context context;
    private ArrayList<EQUIPS> equips;

    public SpinAdapterEquips(Context context, int textViewResourceId,
                       ArrayList<EQUIPS> equips) {
        super(context, textViewResourceId, equips);
        this.context = context;
        this.equips = equips;
    }

    @Override
    public int getCount(){
        return equips.size();
    }

    @Override
    public EQUIPS getItem(int position){
        return equips.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(equips.get(position).getNom());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(equips.get(position).getNom());

        return label;
    }
}