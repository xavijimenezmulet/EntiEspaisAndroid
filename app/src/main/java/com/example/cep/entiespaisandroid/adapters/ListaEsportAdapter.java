package com.example.cep.entiespaisandroid.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.ESPORTS;
import com.example.cep.entiespaisandroid.classes.SEXE;

import java.util.ArrayList;

public class ListaEsportAdapter extends ArrayAdapter<ESPORTS>
{
	private ArrayList<ESPORTS> esportArrayList;
	private Context context;

	public ListaEsportAdapter(@NonNull Context context, ArrayList<ESPORTS> list) {
		super(context, 0 , list);
		this.context = context;
		esportArrayList = list;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View listItem = convertView;
		if(listItem == null)
			listItem = LayoutInflater.from(context).inflate(R.layout.list_equips_entitats,parent,false);

		ESPORTS currentEsport = esportArrayList.get(position);

		TextView name = listItem.findViewById(R.id.txt_nombre_entidad);
		name.setText(currentEsport.getNom());

		return listItem;
	}

	@Override
	public View getDropDownView(int position, View convertView,
								ViewGroup parent) {
		return initView(position, convertView);
	}

	private View initView(int position, View convertView) {
		View listItem = convertView;
		if(listItem == null)
			listItem = LayoutInflater.from(context).inflate(R.layout.list_equips_entitats,null,false);

		ESPORTS currentEsport = esportArrayList.get(position);

		TextView name = listItem.findViewById(R.id.txt_nombre_entidad);
		name.setText(currentEsport.getNom());

		return listItem;
	}
}
