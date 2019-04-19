package com.example.cep.entiespaisandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.adapters.ListFaqsAdapter;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.EntitatService;
import com.example.cep.entiespaisandroid.classes.ENTITATS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FaqsActivity extends AppCompatActivity
{

	private ListView ListFaqs;
	private ImageView ImgLogo1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faqs);

		EntitatService entis = Api.getApi().create(EntitatService.class);

		Call<ArrayList<ENTITATS>> entitats = entis.getEntitats();

		entitats.enqueue(new Callback<ArrayList<ENTITATS>>()
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
		ImgLogo1 = (ImageView)findViewById(R.id.ImgLogo1);
		ImgLogo1.setImageResource(R.drawable.logoprincipal);

		ListFaqs = (ListView)findViewById(R.id.ListFaqs);

		ListFaqsAdapter lf = new ListFaqsAdapter(this, Conexions.faqs);

		ListFaqs.setAdapter(lf);


	}
}
