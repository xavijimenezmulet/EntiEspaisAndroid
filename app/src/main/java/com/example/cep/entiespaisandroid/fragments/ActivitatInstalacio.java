package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.HorariInstalacioService;
import com.example.cep.entiespaisandroid.api.apiService.HoresService;
import com.example.cep.entiespaisandroid.api.apiService.InstalacioService;
import com.example.cep.entiespaisandroid.classes.HORARI_INSTALACIO;
import com.example.cep.entiespaisandroid.classes.HORES;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitatInstalacio extends FragmentActivity implements OnMapReadyCallback
{

	private GoogleMap mMap;
	private INSTALACIONS instalacio = null;
	private ArrayList<HORARI_INSTALACIO> horari_instalacio = null;
	private ArrayList<HORES> hores_instalacion = null;

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

		//Iniciamos arraylist horarios
		horari_instalacio = new ArrayList<>();

		//Iniciamos arraylist hores
		hores_instalacion = new ArrayList<>();

		//CARGAMOS ITEM VIEWS
		TextView nomi = findViewById(R.id.nomIns);
		ImageView imgi = findViewById(R.id.imatgeIns);
		TextView adresi = findViewById(R.id.adresaIns);
		TextView tpii = findViewById(R.id.tipusIns);
		TextView emaili = findViewById(R.id.emailIns);
		TextView teli = findViewById(R.id.telns);
		Button button = findViewById(R.id.horIns);

		//Cargamos datos en los items
		nomi.setText(instalacio.getNom());
		adresi.setText(instalacio.getAdresa());
		tpii.setText(instalacio.getTipus());
		emaili.setText(instalacio.getEmail());

		horarioInstalacion(this);

		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				//Llamada método cargar Dialog Result
				cargarDialog();
			}
		});


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

	//Obtener horarios instalación
	public void horarioInstalacion(final Context con)
	{

		//Retroservice
		HorariInstalacioService horariInstalacioServices = Api.getApi().create(HorariInstalacioService.class);
		Call<ArrayList<HORARI_INSTALACIO>> listCall = horariInstalacioServices.getHorariInstalacio(instalacio.getId());

		//Realizamos llamada y comprobamos el código de respuesta
		listCall.enqueue(new Callback<ArrayList<HORARI_INSTALACIO>>()
		{
			@Override
			public void onResponse(Call<ArrayList<HORARI_INSTALACIO>> call, Response<ArrayList<HORARI_INSTALACIO>> response)
			{
				switch (response.code())
				{
					case 200:
						horari_instalacio = response.body();
						for (int i = 0; i < horari_instalacio.size(); i++)
						{
							int id_hora = horari_instalacio.get(i).getId_hores();
							intervalosHoras(con, id_hora);
						}
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<HORARI_INSTALACIO>> call, Throwable t)
			{
				Toast.makeText(con, "Error", Toast.LENGTH_LONG).show();
			}
		});
	}

	//Obtener intervalos horas
	public void intervalosHoras(final Context con, int id_hora)
	{
		//Retroservice
		HoresService horesService = Api.getApi().create(HoresService.class);
		Call<HORES> listCall = horesService.getHoresId(id_hora);

		listCall.enqueue(new Callback<HORES>()
		{
			@Override
			public void onResponse(Call<HORES> call, Response<HORES> response)
			{
				switch (response.code())
				{
					case 200:
						HORES h = response.body();
						hores_instalacion.add(h);
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<HORES> call, Throwable t)
			{
				Toast.makeText(con, "Error", Toast.LENGTH_LONG).show();
			}
		});
	}

	//Cargar el Dialog Result
	public void cargarDialog()
	{

		AlertDialog.Builder builder = new AlertDialog.Builder(ActivitatInstalacio.this);
		//builder.setTitle("NOMBRE INSTALACION" + " HORARIOS");
		View root = getLayoutInflater().inflate((R.layout.alert_dialog_horari_instalacions), null);

		//CARGAR TEXTVIEWS
		TextView lunesinicio = root.findViewById(R.id.horLunesInicio);
		TextView lunesfinal = root.findViewById(R.id.horLunesFinal);
		TextView martesinicio = root.findViewById(R.id.horMartesInicio);
		TextView martesfinal = root.findViewById(R.id.horMartesFinal);
		TextView miercolesinicio = root.findViewById(R.id.horMiercolesInicio);
		TextView miercolesfinal = root.findViewById(R.id.horMiercolesFinal);
		TextView juevesinicio = root.findViewById(R.id.horJuevesInicio);
		TextView juevesfinal = root.findViewById(R.id.horJuevesFinal);
		TextView viernesinicio = root.findViewById(R.id.horViernesInicio);
		TextView viernesfinal = root.findViewById(R.id.horViernesFinal);
		TextView sabadoinicio = root.findViewById(R.id.horSabadoInicio);
		TextView sabadofinal = root.findViewById(R.id.horSabadoFinal);
		TextView domingoinicio = root.findViewById(R.id.horDomingoInicio);
		TextView domingofinal = root.findViewById(R.id.horDomingoFinal);

		//Lunes
		lunesinicio.setText(hores_instalacion.get(0).getInici());
		lunesfinal.setText(hores_instalacion.get(0).getFi());

		//Martes
		martesinicio.setText(hores_instalacion.get(1).getInici());
		martesfinal.setText(hores_instalacion.get(1).getFi());

		//Miercoles
		miercolesinicio.setText(hores_instalacion.get(2).getInici());
		miercolesfinal.setText(hores_instalacion.get(2).getFi());

		//Jueves
		juevesinicio.setText(hores_instalacion.get(3).getInici());
		juevesfinal.setText(hores_instalacion.get(3).getFi());

		//Viernes
		viernesinicio.setText(hores_instalacion.get(4).getInici());
		viernesfinal.setText(hores_instalacion.get(4).getFi());

		//Sábado
		sabadoinicio.setText(hores_instalacion.get(5).getInici());
		sabadofinal.setText(hores_instalacion.get(5).getFi());

		//Domingo
		domingoinicio.setText(hores_instalacion.get(6).getInici());
		domingofinal.setText(hores_instalacion.get(6).getFi());

		builder.setView(root);
		AlertDialog dlg = builder.show();
		dlg.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));
	}
}
