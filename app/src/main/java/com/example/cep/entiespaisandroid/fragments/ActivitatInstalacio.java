package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.HorariInstalacioService;
import com.example.cep.entiespaisandroid.api.apiService.InstalacioService;
import com.example.cep.entiespaisandroid.classes.HORARI_INSTALACIO;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitatInstalacio extends FragmentActivity implements OnMapReadyCallback
{

	private GoogleMap mMap;
	private Button button;
	private INSTALACIONS instalacio = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instalacio);
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);

		//Obtenemos el objeto instalación
		instalacio = (INSTALACIONS) getIntent().getSerializableExtra("instalacio");

		//CARGAMOS ITEM VIEWS
		TextView nomi = findViewById(R.id.nomIns);
		ImageView imgi = findViewById(R.id.imatgeIns);
		TextView adresi = findViewById(R.id.adresaIns);
		TextView tpii = findViewById(R.id.tipusIns);
		TextView emaili = findViewById(R.id.emailIns);
		TextView teli = findViewById(R.id.telns);
		button = findViewById(R.id.horIns);

		//Cargamos datos en los items
		nomi.setText(instalacio.getNom());
		adresi.setText(instalacio.getAdresa());
		tpii.setText(instalacio.getTipus());
		emaili.setText(instalacio.getEmail());

		//Llamada método cargar Dialog Result
		cargarDialog();

		horarioInstalacion(this);
	}


	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */
	@Override
	public void onMapReady(GoogleMap googleMap)
	{
		mMap = googleMap;

		// Add a marker in Sydney and move the camera
		LatLng mark = new LatLng(instalacio.getAltitut(), instalacio.getLatitut());
		mMap.addMarker(new MarkerOptions().position(mark));
		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mark, 20));
	}

	//Cargar el Dialog Result
	public void cargarDialog()
	{

		//Al pulsar sobre el botón se mostrará un DialogResult con los horarios
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(ActivitatInstalacio.this);
				//builder.setTitle("NOMBRE INSTALACION" + " HORARIOS");
				View root = getLayoutInflater().inflate((R.layout.alert_dialog_horari_instalacions), null);

				builder.setView(root);
				AlertDialog dlg = builder.show();
				dlg.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));
			}
		});
	}

	//Obtener horarios instalación
	public void horarioInstalacion(final Context con)
	{

		//Retroservice
		HorariInstalacioService horariInstalacioServices = Api.getApi().create(HorariInstalacioService.class);
		int id = instalacio.getId();
		Call<ArrayList<HORARI_INSTALACIO>> listCall = horariInstalacioServices.getHorariInstalacio();

		//Realizamos llamada y comprobamos el código de respuesta
		listCall.enqueue(new Callback<ArrayList<HORARI_INSTALACIO>>()
		{
			@Override
			public void onResponse(Call<ArrayList<HORARI_INSTALACIO>> call, Response<ArrayList<HORARI_INSTALACIO>> response)
			{

			}

			@Override
			public void onFailure(Call<ArrayList<HORARI_INSTALACIO>> call, Throwable t)
			{
				Toast.makeText(con, "Error", Toast.LENGTH_LONG).show();
			}
		});
	}
}
