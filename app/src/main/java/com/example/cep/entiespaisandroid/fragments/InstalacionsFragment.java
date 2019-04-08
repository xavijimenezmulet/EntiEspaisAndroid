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
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstalacionsFragment extends Fragment implements OnMapReadyCallback
{
	private RecyclerView recyclerView;
	private ArrayList<INSTALACIONS> instalacions;
	private GoogleMap mMap;

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
		//DATOS SIN API
		instalacions = new ArrayList<>();
		instalacions.add(new INSTALACIONS(1, "Sabadell Poliesportiu", "pepe", "C/Lepanto 150",
				"Externo", "sabadellpoli@gmail.com", "C:\\Users\\Public\\Pictures\\SamplePictures\\Koala.jpeg", 41.388615, 2.173136));
		instalacions.add(new INSTALACIONS(2, "Valencia Poliesportiu", "dadwdwa", "C/Ribas 150",
				"Externo", "valenpoli@gmail.com", "C:\\Users\\Public\\Pictures\\SamplePictures\\Koala.jpeg", 41.390523, 2.174123));

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
				Intent intent = new Intent(getContext(), ActivitatInstalacio.class);
				intent.putExtra("instalacio", i);
				startActivity(intent);
			}
		});
		//FIN
		*/


		instalacions = Conexions.instalacions;

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
								Intent intent = new Intent(getContext(), ActivitatInstalacio.class);
								intent.putExtra("instalacio", i);
								startActivity(intent);
							}
						});




		//Cargamos mapa y comprobamos estado
		SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

		if (mapFragment != null)
		{
			mapFragment.getMapAsync(this);
		}

	}

	//Cargamos mapa
	@Override
	public void onMapReady(GoogleMap googleMap)
	{
		mMap = googleMap;

		for (INSTALACIONS i : instalacions)
		{

			LatLng coord = new LatLng(i.getAltitut(), i.getLatitut());
			Marker marker = mMap.addMarker(new MarkerOptions().position(coord).title(i.getNom()));
			marker.setTag(i);
		}

		// Add a marker in Sydney and move the camera
		LatLng def = new LatLng(41.4719, 2.08214);
		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(def, 15));


		mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
		{
			@Override
			public boolean onMarkerClick(Marker marker)
			{
				INSTALACIONS i = (INSTALACIONS) marker.getTag();
				Intent intent = new Intent(getContext(), ActivitatInstalacio.class);
				intent.putExtra("instalacio", i);
				startActivity(intent);

				return false;
			}
		});

	}
}
