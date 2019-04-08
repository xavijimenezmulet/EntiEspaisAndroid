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
import com.example.cep.entiespaisandroid.api.apiService.CategoriaEdatService;
import com.example.cep.entiespaisandroid.api.apiService.CategoriaEquipService;
import com.example.cep.entiespaisandroid.api.apiService.CompeticioService;
import com.example.cep.entiespaisandroid.api.apiService.ActivitatsService;
import com.example.cep.entiespaisandroid.api.apiService.Demanda_ActService;
import com.example.cep.entiespaisandroid.api.apiService.Dia_SemanaService;
import com.example.cep.entiespaisandroid.api.apiService.Dias_DemandaService;
import com.example.cep.entiespaisandroid.api.apiService.EntitatService;
import com.example.cep.entiespaisandroid.api.apiService.EquipService;
import com.example.cep.entiespaisandroid.api.apiService.EsportService;
import com.example.cep.entiespaisandroid.api.apiService.SexeService;
import com.example.cep.entiespaisandroid.classes.CATEGORIA_EDAT;
import com.example.cep.entiespaisandroid.classes.CATEGORIA_EQUIP;
import com.example.cep.entiespaisandroid.classes.COMPETICIONS;
import com.example.cep.entiespaisandroid.api.apiService.EsportsService;
import com.example.cep.entiespaisandroid.api.apiService.FaqsService;
import com.example.cep.entiespaisandroid.api.apiService.EquipService;
import com.example.cep.entiespaisandroid.api.apiService.EspaisService;
import com.example.cep.entiespaisandroid.api.apiService.Horari_InstalacioService;
import com.example.cep.entiespaisandroid.api.apiService.HoresService;
import com.example.cep.entiespaisandroid.api.apiService.InstalacionsService;
import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.DIAS_DEMANDA;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.ENTITATS;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.ESPORTS;
import com.example.cep.entiespaisandroid.classes.SEXE;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.example.cep.entiespaisandroid.classes.ESPORTS;
import com.example.cep.entiespaisandroid.classes.FAQS;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.ESPAIS;
import com.example.cep.entiespaisandroid.classes.HORARI_INSTALACIO;
import com.example.cep.entiespaisandroid.classes.HORES;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;
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
							!= PackageManager.PERMISSION_GRANTED &&
					ContextCompat.checkSelfPermission((Activity)this,
							Manifest.permission.INTERNET)
							!= PackageManager.PERMISSION_GRANTED &&
					ContextCompat.checkSelfPermission((Activity)this,
					Manifest.permission.ACCESS_FINE_LOCATION)
					!= PackageManager.PERMISSION_GRANTED &&
					ContextCompat.checkSelfPermission((Activity)this,
					Manifest.permission.ACCESS_COARSE_LOCATION)
					!= PackageManager.PERMISSION_GRANTED)
			{

				// Si l'usuari no ens havia atorgat permisos, els hi demanem i
				// executem el nostre codi

				ActivityCompat.requestPermissions(this,
						new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
								Manifest.permission.WRITE_EXTERNAL_STORAGE,
								Manifest.permission.INTERNET,
								Manifest.permission.ACCESS_FINE_LOCATION,
								Manifest.permission.ACCESS_COARSE_LOCATION},
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

		//================================================================================
		// Rellenar ArrayList<ENTITATS> con todas las entidades de la BD.
		//================================================================================

		EntitatService es = Api.getApi().create(EntitatService.class);

		Call<ArrayList<ENTITATS>> e = es.getEntitats();

		e.enqueue(new Callback<ArrayList<ENTITATS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<ENTITATS>> call, Response<ArrayList<ENTITATS>> response)
			{
				switch (response.code()){
					case 200:
						Conexions.entitats = response.body();
						String nom = Conexions.entitats.get(0).getNom().toString();
						//Toast.makeText(SplashActivity.this, nom , Toast.LENGTH_LONG).show();
						break;
					case 400:
						//Toast.makeText(SplashActivity.this, response.toString(), Toast.LENGTH_LONG).show();
						break;
					case 503:
						//Toast.makeText(SplashActivity.this, response.toString(), Toast.LENGTH_LONG).show();
						Conexions.entitats = response.body();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<ENTITATS>> call, Throwable t)
			{
				//Toast.makeText(SplashActivity.this, "HA IDO MAL" , Toast.LENGTH_LONG).show();
			}
		});

		FaqsService fs = Api.getApi().create(FaqsService.class);

		Call<ArrayList<FAQS>> f = fs.getFaqs();

		f.enqueue(new Callback<ArrayList<FAQS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<FAQS>> call, Response<ArrayList<FAQS>> response)
			{
				switch (response.code()){
					case 200:
						Conexions.faqs = response.body();
						break;
					case 400:
						Toast.makeText(SplashActivity.this, response.toString(), Toast.LENGTH_LONG).show();
						break;
					case 503:
						Toast.makeText(SplashActivity.this, response.toString(), Toast.LENGTH_LONG).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<FAQS>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL" , Toast.LENGTH_LONG).show();
				Toast.makeText(SplashActivity.this, t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});

		//================================================================================
		// Rellenar ArrayList<EQUIPS> con todos los equipos de la BD.
		//================================================================================

		/*EquipService equipService = Api.getApi().create(EquipService.class);

		Call<ArrayList<EQUIPS>> listCall = equipService.getEquips();

		listCall.enqueue(new Callback<ArrayList<EQUIPS>>() {
			@Override
			public void onResponse(Call<ArrayList<EQUIPS>> call, Response<ArrayList<EQUIPS>> response) {
				switch(response.code()) {
					case 200:
						Conexions.equips = response.body();
						break;
					case 400:
						Toast.makeText(SplashActivity.this, response.message().toString(), Toast.LENGTH_LONG).show();
						break;
					case 503:
						Toast.makeText(SplashActivity.this, response.message().toString(), Toast.LENGTH_LONG).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<EQUIPS>> call, Throwable t) {
				Toast.makeText(SplashActivity.this, t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});*/


		//================================================================================
		// Rellenar ArrayList<COMPETICIONS> con todas las competiciones de la BD.
		//================================================================================

		CompeticioService competicioService = Api.getApi().create(CompeticioService.class);

		Call<ArrayList<COMPETICIONS>> listCall1 = competicioService.getCompeticions();

		listCall1.enqueue(new Callback<ArrayList<COMPETICIONS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<COMPETICIONS>> call, Response<ArrayList<COMPETICIONS>> response)
			{
				switch (response.code()) {
					case 200:
						Conexions.competicions = response.body();
						break;
					default:
						break;
				}

			}

			@Override
			public void onFailure(Call<ArrayList<COMPETICIONS>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});

		//================================================================================
		// Rellenar ArrayList<CATEGORIA_EDAT> con todas las categorias de edad de la BD.
		//================================================================================

		CategoriaEdatService categoriaEdatService = Api.getApi().create(CategoriaEdatService.class);

		Call<ArrayList<CATEGORIA_EDAT>> listCall2 = categoriaEdatService.getCategoriasEdats();

		listCall2.enqueue(new Callback<ArrayList<CATEGORIA_EDAT>>()
		{
			@Override
			public void onResponse(Call<ArrayList<CATEGORIA_EDAT>> call, Response<ArrayList<CATEGORIA_EDAT>> response)
			{
				switch(response.code()) {
					case 200:
						Conexions.categoria_edats = response.body();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<CATEGORIA_EDAT>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});

		//================================================================================
		// Rellenar ArrayList<CATEGORIA_EQUIP> con todas las categorias de equipo de la BD.
		//================================================================================

		CategoriaEquipService categoriaEquipService = Api.getApi().create(CategoriaEquipService.class);

		Call<ArrayList<CATEGORIA_EQUIP>> listCall3 = categoriaEquipService.getCategoriasEquips();

		listCall3.enqueue(new Callback<ArrayList<CATEGORIA_EQUIP>>()
		{
			@Override
			public void onResponse(Call<ArrayList<CATEGORIA_EQUIP>> call, Response<ArrayList<CATEGORIA_EQUIP>> response)
			{
				switch(response.code()) {
					case 200:
						Conexions.categoria_equips = response.body();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<CATEGORIA_EQUIP>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});

		//================================================================================
		// Rellenar ArrayList<SEXE> con todos los sexos de la BD.
		//================================================================================

		SexeService sexeService = Api.getApi().create(SexeService.class);

		Call<ArrayList<SEXE>> listCall4 = sexeService.getSexes();

		listCall4.enqueue(new Callback<ArrayList<SEXE>>()
		{
			@Override
			public void onResponse(Call<ArrayList<SEXE>> call, Response<ArrayList<SEXE>> response)
			{
				switch(response.code()) {
					case 200:
						Conexions.sexes = response.body();
						Toast.makeText(SplashActivity.this, Conexions.sexes.get(0).getTipus(), Toast.LENGTH_LONG).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<SEXE>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});

		//================================================================================
		// Rellenar ArrayList<ESPORTS> con todos los deportes de la BD.
		//================================================================================
		EsportService esportService = Api.getApi().create(EsportService.class);

		Call<ArrayList<ESPORTS>> listCall5 = esportService.getEsports();

		listCall5.enqueue(new Callback<ArrayList<ESPORTS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<ESPORTS>> call, Response<ArrayList<ESPORTS>> response)
			{
				switch(response.code()) {
					case 200:
						Conexions.esports = response.body();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<ESPORTS>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
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
			if(grantResults.length==5 && grantResults[0]==PackageManager.PERMISSION_GRANTED &&
					grantResults[1]==PackageManager.PERMISSION_GRANTED && grantResults[2]==PackageManager.PERMISSION_GRANTED &&
					grantResults[3]==PackageManager.PERMISSION_GRANTED && grantResults[4]==PackageManager.PERMISSION_GRANTED ){
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

		ActivitatsService as = Api.getApi().create(ActivitatsService.class);

		Call<ArrayList<ACTIVITATS>> acts = as.getActivitats();

		acts.enqueue(new Callback<ArrayList<ACTIVITATS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<ACTIVITATS>> call, Response<ArrayList<ACTIVITATS>> response)
			{
				switch (response.code())
				{
					case 200:
						Conexions.activitats = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<ACTIVITATS>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});

		InstalacionsService is = Api.getApi().create(InstalacionsService.class);

		Call<ArrayList<INSTALACIONS>> inst = is.getInstalacions();

		inst.enqueue(new Callback<ArrayList<INSTALACIONS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<INSTALACIONS>> call, Response<ArrayList<INSTALACIONS>> response)
			{
				switch (response.code())
				{
					case 200:
						Conexions.instalacions = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<INSTALACIONS>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});

		EspaisService esps = Api.getApi().create(EspaisService.class);

		Call<ArrayList<ESPAIS>> espais = esps.getEspais();

		espais.enqueue(new Callback<ArrayList<ESPAIS>>()
		{
			@Override
			public void onResponse(Call<ArrayList<ESPAIS>> call, Response<ArrayList<ESPAIS>> response)
			{
				switch (response.code())
				{
					case 200:
						Conexions.espais = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<ESPAIS>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});

		Horari_InstalacioService his = Api.getApi().create(Horari_InstalacioService.class);

		Call<ArrayList<HORARI_INSTALACIO>> horarisI = his.getHorariInstalacio();

		horarisI.enqueue(new Callback<ArrayList<HORARI_INSTALACIO>>()
		{
			@Override
			public void onResponse(Call<ArrayList<HORARI_INSTALACIO>> call, Response<ArrayList<HORARI_INSTALACIO>> response)
			{
				switch (response.code())
				{
					case 200:
						Conexions.horari_instalacios = response.body();
						//Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<HORARI_INSTALACIO>> call, Throwable t)
			{
				Toast.makeText(SplashActivity.this, "HA IDO MAL", Toast.LENGTH_LONG).show();
			}
		});
	}
}
