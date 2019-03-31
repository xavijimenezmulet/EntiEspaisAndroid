package com.example.cep.entiespaisandroid.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.adapters.AdapterInstalaciones;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.InstalacioService;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstalacionsFragment extends Fragment
{
	private RecyclerView recyclerView;
	private ArrayList<INSTALACIONS> instalacions;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState)
	{

		return inflater.inflate(R.layout.fragment_instalacions, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state)
	{
		super.onActivityCreated(state);

		/*
		instalacions = new ArrayList<>();
		instalacions.add(new INSTALACIONS(1, "Sabadell Poliesportiu", "pepe", "C/Lepanto 150",
				"Externo", "sabadellpoli@gmail.com", "C:\\Users\\Public\\Pictures\\SamplePictures\\Koala.jpeg", 150, 145));
		instalacions.add(new INSTALACIONS(2, "Valencia Poliesportiu", "dadwdwa", "C/Ribas 150",
				"Externo", "valenpoli@gmail.com", "C:\\Users\\Public\\Pictures\\SamplePictures\\Koala.jpeg", 145, 160));

		*/

		InstalacioService instalacioService = Api.getApi().create(InstalacioService.class);
		Call<ArrayList<INSTALACIONS>> listCall = instalacioService.getInstalacions();

		listCall.enqueue(new Callback<ArrayList<INSTALACIONS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<INSTALACIONS>> call, Response<ArrayList<INSTALACIONS>> response)
			{
				switch (response.code()){
					case 200:
						instalacions = response.body();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<INSTALACIONS>> call, Throwable t)
			{
				Toast.makeText(getContext(), t.getCause() + t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});

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
