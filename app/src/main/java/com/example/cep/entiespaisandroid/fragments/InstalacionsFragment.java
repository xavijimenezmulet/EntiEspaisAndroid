package com.example.cep.entiespaisandroid.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;

import java.util.ArrayList;

public class InstalacionsFragment extends Fragment
{
	private RecyclerView recyclerView;
	private ArrayList<INSTALACIONS> instalacions;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_instalacions, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);

		instalacions = new ArrayList<>();
		instalacions.add(new INSTALACIONS(1, "Sabadell Poliesporiu", "pepe", "C/Lepanto 150",
				"Externo", "sabadellpoli@gmail.com", "\\lelel.png", 150, 145));
		recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerInstalacions);
		recyclerView.setHasFixedSize(true);

		final AdapterInstalaciones adaptador = new AdapterInstalaciones(instalacions);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		recyclerView.setAdapter(adaptador);

		adaptador.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				INSTALACIONS i = instalacions.get(recyclerView.getChildAdapterPosition(v));
				Intent intent = new Intent(getContext(), FragmentInstalacio.class);
				//intent.putExtra("instalacio", i);
				startActivity(intent);
			}
		});
	}
}
