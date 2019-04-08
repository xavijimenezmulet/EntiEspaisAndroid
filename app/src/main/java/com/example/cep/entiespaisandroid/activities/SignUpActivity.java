package com.example.cep.entiespaisandroid.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.EntitatService;
import com.example.cep.entiespaisandroid.classes.ENTITATS;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.example.cep.entiespaisandroid.utilities.Utilitats;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity
{

	private AutoCompleteTextView entitat;
	private AutoCompleteTextView email1;
	private EditText password1;
	private EditText passwordRepite;
	private AutoCompleteTextView nif;
	private AutoCompleteTextView adresa;
	private AutoCompleteTextView telefonobligatori;
	private AutoCompleteTextView telefonopcional;
	private Button signupButton;
	private Button cancelarButton;
	private ImageView ImgSignUp;
	private LocationManager locManager;
	private Location loc;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);

		entitat = (AutoCompleteTextView) findViewById(R.id.entitat);
		email1 = (AutoCompleteTextView) findViewById(R.id.email1);
		password1 = (EditText) findViewById(R.id.password1);
		passwordRepite = (EditText) findViewById(R.id.passwordRepite);
		nif = (AutoCompleteTextView) findViewById(R.id.nif);
		adresa = (AutoCompleteTextView) findViewById(R.id.adresa);
		telefonobligatori = (AutoCompleteTextView) findViewById(R.id.telefonobligatori);
		telefonopcional = (AutoCompleteTextView) findViewById(R.id.telefonopcional);
		cancelarButton = (Button) findViewById(R.id.cancelarButton);
		signupButton = (Button) findViewById(R.id.signupButton);
		ImgSignUp = (ImageView) findViewById(R.id.ImgSignup);
		ImgSignUp.setImageResource(R.drawable.logoprincipal);
		locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		cancelarButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				finish();
			}
		});

		signupButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				attemptSignUp();
			}
		});

	}

	public void attemptSignUp()
	{
		entitat.setError(null);
		email1.setError(null);
		password1.setError(null);
		passwordRepite.setError(null);
		nif.setError(null);
		adresa.setError(null);
		telefonobligatori.setError(null);
		telefonopcional.setError(null);


		String nomEntitat = entitat.getText().toString();
		String email = email1.getText().toString();
		String password = password1.getText().toString();
		String passworR = passwordRepite.getText().toString();
		String nifEntitat = nif.getText().toString();
		String adresaEntitat = adresa.getText().toString();
		String telefonO = telefonobligatori.getText().toString();
		String telefonoPC = telefonopcional.getText().toString();

		boolean cancel = false;
		View focusView = null;

		if (nomEntitat.equals(""))
		{
			entitat.setError(getString(R.string.obligatori));
			focusView = entitat;
			cancel = true;
		} else if (email.equals("") && !email.contains("@"))
		{
			email1.setError(getString(R.string.obligatori));
			focusView = email1;
			cancel = true;
		} else if (password.equals("") && password.length() < 5)
		{
			password1.setError(getString(R.string.obligatori));
			focusView = password1;
			cancel = true;
		} else if (passworR.equals("") && password.length() < 5)
		{
			passwordRepite.setError(getString(R.string.obligatori));
			focusView = passwordRepite;
			cancel = true;
		} else if (nifEntitat.equals(""))
		{

			nif.setError(getString(R.string.obligatori));
			focusView = nif;
			cancel = true;
		} else if (adresaEntitat.equals(""))
		{
			adresa.setError(getString(R.string.obligatori));
			focusView = adresa;
			cancel = true;
		} else if (telefonO.equals("") || !Utilitats.isNumeric(telefonO) && telefonO.length() != 9)
		{
			telefonobligatori.setError(getString(R.string.obligatori));
			focusView = telefonobligatori;
			cancel = true;
		}
		else if(!telefonoPC.equals("")){
			if(!Utilitats.isNumeric(telefonoPC) && telefonO.length() != 9){
				telefonopcional.setError(getString(R.string.obligatori));
				focusView = telefonopcional;
				cancel = true;
			}
		}
		else
		{
			Conexions.entitat_conectada = new ENTITATS();
			Conexions.entitat_conectada.setTemporada("2018-2019");
			Conexions.entitat_conectada.setNom(nomEntitat);
			Conexions.entitat_conectada.setEmail(email);
			Conexions.entitat_conectada.setRuta_imagen("http://cdn.ertheo.com/blog/wp-content/uploads/2018/06/Fc_barcelona.png");
			Conexions.entitat_conectada.setRuta_video("http://techslides.com/demos/sample-videos/small.mp4");
			Conexions.entitat_conectada.setNif(nifEntitat);
			Conexions.entitat_conectada.setAdresa(adresaEntitat);
			Conexions.entitat_conectada.setContrassenya(Utilitats.encriptar(password));

			if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
			{
				// TODO: Consider calling
				//    ActivityCompat#requestPermissions
				// here to request the missing permissions, and then overriding
				//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
				//                                          int[] grantResults)
				// to handle the case where the user grants the permission. See the documentation
				// for ActivityCompat#requestPermissions for more details.
				return;
			}

			Geocoder geocoder = new Geocoder(SignUpActivity.this);
			List<Address> addresses = null;

			try
			{
				addresses = geocoder.getFromLocationName(adresaEntitat, 1);

			} catch (IOException e)
			{
				e.printStackTrace();
			}
			if(addresses.size() > 0) {
				double latitude= addresses.get(0).getLatitude();
				Conexions.entitat_conectada.setLatitud(latitude);
				double longitude= addresses.get(0).getLongitude();
				Conexions.entitat_conectada.setAltitud(longitude);
			}

			int tamany = Conexions.entitats.size();
			EntitatService es = Api.getApi().create(EntitatService.class);

			Call<ENTITATS> e = es.setEntitat(Conexions.entitat_conectada);

			e.enqueue(new Callback<ENTITATS>()
			{
				@Override
				public void onResponse(Call<ENTITATS> call, Response<ENTITATS> response)
				{

				}

				@Override
				public void onFailure(Call<ENTITATS> call, Throwable t)
				{

				}
			});

			finish();




		}
	}


}
