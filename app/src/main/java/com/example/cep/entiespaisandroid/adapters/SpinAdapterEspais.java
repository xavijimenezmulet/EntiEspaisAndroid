package com.example.cep.entiespaisandroid.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.ESPAIS;

import java.util.ArrayList;

public class SpinAdapterEspais extends ArrayAdapter<ESPAIS> {

    private Context context;
    private ArrayList<ESPAIS> espais;

    public SpinAdapterEspais(Context context, int textViewResourceId,
                             ArrayList<ESPAIS> espais) {
        super(context, textViewResourceId, espais);
        this.context = context;
        this.espais = espais;
    }

    @Override
    public int getCount(){
        return espais.size();
    }

    @Override
    public ESPAIS getItem(int position){
        return espais.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(espais.get(position).getNom());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(espais.get(position).getNom());

        return label;
    }
}