package com.example.cep.entiespaisandroid.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.FAQS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

public class ListFaqsAdapter extends ArrayAdapter<FAQS>
{
	private ArrayList<FAQS> faqs;
	public ListFaqsAdapter(Context context, ArrayList<FAQS> faqs){
		super(context, R.layout.item_faqs, faqs);
		this.faqs = faqs;
	}

	public View getView(int posicion, View convertView, ViewGroup parent){
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View objeto = inflater.inflate(R.layout.item_faqs, null);

		TextView pregunta = (TextView) objeto.findViewById(R.id.pregunta);
		pregunta.setText(faqs.get(posicion).getPregunta().toString());

		TextView respuesta = (TextView) objeto.findViewById(R.id.respuesta);
		respuesta.setText(faqs.get(posicion).getDescripcion().toString());

		return objeto;
	}
}

