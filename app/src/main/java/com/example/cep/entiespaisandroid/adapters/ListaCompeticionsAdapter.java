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
import com.example.cep.entiespaisandroid.classes.COMPETICIONS;
import com.example.cep.entiespaisandroid.classes.ENTITATS;

import java.util.ArrayList;

public class ListaCompeticionsAdapter extends ArrayAdapter<COMPETICIONS>
{
	private ArrayList<COMPETICIONS> competicionsArrayList;
	private Context context;

	public ListaCompeticionsAdapter(@NonNull Context context, ArrayList<COMPETICIONS> list) {
		super(context, 0 , list);
		this.context = context;
		competicionsArrayList = list;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View listItem = convertView;
		if(listItem == null)
			listItem = LayoutInflater.from(context).inflate(R.layout.list_equips_entitats,parent,false);

		COMPETICIONS currentCompeticio = competicionsArrayList.get(position);

		TextView name = listItem.findViewById(R.id.txt_nombre_entidad);
		name.setText(currentCompeticio.getNom());

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

		COMPETICIONS currentCompeticio = competicionsArrayList.get(position);

		TextView name = listItem.findViewById(R.id.txt_nombre_entidad);
		name.setText(currentCompeticio.getNom());

		return listItem;
	}
}
