package com.example.cep.entiespaisandroid.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.Demanda_ActService;
import com.example.cep.entiespaisandroid.api.apiService.Dia_SemanaService;
import com.example.cep.entiespaisandroid.api.apiService.Dias_DemandaService;
import com.example.cep.entiespaisandroid.api.apiService.EntitatService;
import com.example.cep.entiespaisandroid.api.apiService.EquipService;
import com.example.cep.entiespaisandroid.api.apiService.HoresService;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.DIAS_DEMANDA;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.ENTITATS;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.HORES;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity
{

	private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
	private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;

	// Duración en milisegundos que se mostrará el splash
	private final int DURACION_SPLASH = 5000; // 5 segundos
	private ImageView ImgSplash;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);



		//	COM DEMANAR PERMISOS EN DISPOSITIUS AMB UNA VERSIÓ D'ANDROID 6.O O SUPERIOR

		// Here, thisActivity is the current activity

		// Controlem la versió d'Android que estem executant.
		if (android.os.Build.VERSION.SDK_INT >= 23)
		{
			// Si executem la versió Marshmallow (6.0) o posterior, haurem de demanar
			// permisos en temps d'execució

			// Comprovem si l'usuari ja ens ha donat permisos en una execió anterior
			if (ContextCompat.checkSelfPermission((Activity)this,
					Manifest.permission.READ_EXTERNAL_STORAGE)
					!= PackageManager.PERMISSION_GRANTED &&
					ContextCompat.checkSelfPermission((Activity)this,
							Manifest.permission.WRITE_EXTERNAL_STORAGE)
							!= PackageManager.PERMISSION_GRANTED)
			{

				// Si l'usuari no ens havia atorgat permisos, els hi demanem i
				// executem el nostre codi

				ActivityCompat.requestPermissions(this,
						new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
								Manifest.permission.WRITE_EXTERNAL_STORAGE},
						1);

				iniciar();
			}
			else
			{
				// Si l'usuari ja ens havia atorgat permisos en una execució anterior,
				// executem directament el nostre codi

				iniciar();
			}
		}
		else
		{

			// Si executem una versió anterior a la versió Marshmallow (6.0),
			// no cal demanar cap permís, i podem executar el nostre codi directament

			iniciar();
		}

	}

	protected void iniciar()
	{
		carregarDades();
		ImgSplash = (ImageView)findViewById(R.id.ImgSplash);
		ImgSplash.setImageResource(R.drawable.splashandroid);

		EntitatService es = Api.getApi().create(EntitatService.class);

		Call<ArrayList<ENTITATS>> e = es.getEntitats();

		e.enqueue(new Callback<ArrayList<ENTITATS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<ENTITATS>> call, Response<ArrayList<ENTITATS>> response)
			{
				switch (response.code()){
					case 200:
						ArrayList<ENTITATS> entitats = response.body();
						String nom = entitats.get(0).getNom().toString();
						Toast.makeText(SplashActivity.this, nom , Toast.LENGTH_LONG).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<ENTITATS>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL" , Toast.LENGTH_LONG).show();
			}
		});





		new Thread(){
			public void run(){
				try{
					// Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
					sleep(DURACION_SPLASH);
					startActivity(new Intent(SplashActivity.this, LoginActivity.class));
				} catch (InterruptedException ex){
					ex.printStackTrace();
				}

			};
		}.start();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
	{
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		if(requestCode == 1){
			if(grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED &&
					grantResults[1]==PackageManager.PERMISSION_GRANTED){
				iniciar();
			}
		}
	}
	protected void carregarDades()
	{
		Demanda_ActService ds = Api.getApi().create(Demanda_ActService.class);

		Call<ArrayList<DEMANDA_ACT>> dem = ds.getDemanda_acts();

		dem.enqueue(new Callback<ArrayList<DEMANDA_ACT>>()
		{
			@Override
			public void onResponse(Call<ArrayList<DEMANDA_ACT>> call, Response<ArrayList<DEMANDA_ACT>> response)
			{
				switch (response.code())
				{
					case 200:
						Conexions.demanda_acts = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<DEMANDA_ACT>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});

		EquipService es = Api.getApi().create(EquipService.class);

		Call<ArrayList<EQUIPS>> eq = es.getEquips();

		eq.enqueue(new Callback<ArrayList<EQUIPS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<EQUIPS>> call, Response<ArrayList<EQUIPS>> response)
			{
				switch (response.code())
				{
					case 200:
						Conexions.equips = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<EQUIPS>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});

		HoresService hs = Api.getApi().create(HoresService.class);

		Call<ArrayList<HORES>> h = hs.getHores();

		h.enqueue(new Callback<ArrayList<HORES>>()
		{
			@Override
			public void onResponse(Call<ArrayList<HORES>> call, Response<ArrayList<HORES>> response)
			{
				switch (response.code())
				{
					case 200:Conexions.hores = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<HORES>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});

		Dia_SemanaService dss = Api.getApi().create(Dia_SemanaService.class);

		Call<ArrayList<DIA_SEMANA>> d = dss.getDiasSemana();

		d.enqueue(new Callback<ArrayList<DIA_SEMANA>>()
		{
			@Override
			public void onResponse(Call<ArrayList<DIA_SEMANA>> call, Response<ArrayList<DIA_SEMANA>> response)
			{
				switch (response.code())
				{
					case 200:
						Conexions.dies_setmana = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<DIA_SEMANA>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});

		Dias_DemandaService dds = Api.getApi().create(Dias_DemandaService.class);

		Call<ArrayList<DIAS_DEMANDA>> dd = dds.getDias_demanda();

		dd.enqueue(new Callback<ArrayList<DIAS_DEMANDA>>()
		{
			@Override
			public void onResponse(Call<ArrayList<DIAS_DEMANDA>> call, Response<ArrayList<DIAS_DEMANDA>> response)
			{
				switch (response.code())
				{
					case 200:
						Conexions.dias_demanda = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<DIAS_DEMANDA>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});
	}
}
