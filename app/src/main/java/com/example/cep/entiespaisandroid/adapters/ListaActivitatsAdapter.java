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
import com.example.cep.entiespaisandroid.classes.ACTIVITATS;

import java.util.ArrayList;

public class ListaActivitatsAdapter extends ArrayAdapter<ACTIVITATS>
{
	private ArrayList<ACTIVITATS> activitatsArrayList;
	private Context context;

	public ListaActivitatsAdapter(@NonNull Context context, ArrayList<ACTIVITATS> list) {
		super(context, 0 , list);
		this.context = context;
		activitatsArrayList = list;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View listItem = convertView;
		if(listItem == null)
			listItem = LayoutInflater.from(context).inflate(R.layout.list_equips_activitats,parent,false);

		ACTIVITATS currentActivitat = activitatsArrayList.get(position);

		TextView name = listItem.findViewById(R.id.txt_nombre_actividad);
		name.setText(currentActivitat.getNom());

		return listItem;
	}

}
