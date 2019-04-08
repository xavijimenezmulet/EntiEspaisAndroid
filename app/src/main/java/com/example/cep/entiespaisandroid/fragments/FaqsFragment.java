package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.FAQS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

public class FaqsFragment extends Fragment
{

	private ImageView ImgLogo1;
	private ListView ListFaqs;
	private LinearLayout linearFaqs;
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater,
							 @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.activity_faqs, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		ImgLogo1 = (ImageView)getView().findViewById(R.id.ImgLogo1);
		linearFaqs = (LinearLayout)getView().findViewById(R.id.linearFaqs);
		ImgLogo1.setImageResource(R.drawable.logoprincipal);
		linearFaqs.setBackgroundResource(R.color.blanco);

		ListFaqs = (ListView)getView().findViewById(R.id.ListFaqs);

		FaqsAdapter fa = new FaqsAdapter(this, Conexions.faqs);

		ListFaqs.setAdapter(fa);


	}

	class FaqsAdapter extends ArrayAdapter<FAQS>
	{

		Activity context;
		ArrayList<FAQS> faqs;

		FaqsAdapter(Fragment context, ArrayList<FAQS> f) {
			super(context.getActivity(), R.layout.item_faqs, f);
			this.context = context.getActivity();
			faqs= f;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View objeto = inflater.inflate(R.layout.item_faqs, null);

			TextView pregunta = (TextView) objeto.findViewById(R.id.pregunta);
			pregunta.setText(Conexions.faqs.get(position).getPregunta().toString());

			TextView respuesta = (TextView) objeto.findViewById(R.id.respuesta);
			respuesta.setText(Conexions.faqs.get(position).getDescripcion().toString());

			return(objeto);
		}
	}
}
