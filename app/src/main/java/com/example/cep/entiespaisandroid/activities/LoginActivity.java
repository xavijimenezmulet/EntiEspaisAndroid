package com.example.cep.entiespaisandroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.EntitatService;
import com.example.cep.entiespaisandroid.classes.ENTITATS;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.example.cep.entiespaisandroid.utilities.Utilitats;

import java.util.ArrayList;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity
{
	public static int contador;
	private ImageView ImgLogin;

	// UI references.
	private AutoCompleteTextView mEmailView;
	private EditText mPasswordView;
	private TextView TextFaqs;
	private TextView TextPolitica;
	private Button email_sign_up_button;
	private Button email_sign_in_button;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ImgLogin = (ImageView)findViewById(R.id.ImgLogin);
		ImgLogin.setImageResource(R.drawable.logoprincipal);


		contador = 0;

		TextFaqs = (TextView)findViewById(R.id.TextFaqs);
		TextPolitica = (TextView)findViewById(R.id.TextPolitica);

		TextFaqs.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent i = new Intent(LoginActivity.this, FaqsActivity.class);
				startActivity(i);
			}
		});

		TextPolitica.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent i = new Intent(LoginActivity.this, PoliticaEmpresaActivity.class);
				startActivity(i);
			}
		});

		// Set up the login form.
		mEmailView = (AutoCompleteTextView) findViewById(R.id.email);


		mPasswordView = (EditText) findViewById(R.id.password);

		email_sign_in_button = (Button) findViewById(R.id.email_sign_in_button);
		email_sign_up_button = (Button) findViewById(R.id.email_sign_up_button);
		email_sign_in_button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				attemptLogin();
				contador++;
			}
		});
		email_sign_up_button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
				startActivity(i);
			}
		});

	}






	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	private void attemptLogin()
	{
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


		// Reset errors.
		mEmailView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		String email = mEmailView.getText().toString();
		String password = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password, if the user entered one.
		if (!TextUtils.isEmpty(password) && !isPasswordValid(password))
		{
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(email))
		{
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
			cancel = true;
		} else if (!isEmailValid(email))
		{
			mEmailView.setError(getString(R.string.error_invalid_email));
			focusView = mEmailView;
			cancel = true;
		}

		if (cancel)
		{
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else
		{
			if (!comprobarEmail(email)){
				mEmailView.setError("Bad credentials!");
				focusView = mEmailView;
				cancel = true;
			}
			else{
				if (!comprobarContrasenya(password)){
					mEmailView.setError("Bad credentials!");
					focusView = mEmailView;
					cancel = true;
				}
				else{
					Intent intent = new Intent(new Intent(LoginActivity.this, MainActivity.class));
					startActivity(intent);
				}
			}

		}
	}

	private Boolean comprobarContrasenya(String password)
	{
		Boolean verdadero = false;


		if(Utilitats.verificar(password)){
			verdadero = true;
		}

		return verdadero;
	}

	private Boolean comprobarEmail(String email)
	{
		int i = 0;
		Boolean verdadero = false;
		do{
			ENTITATS e = Conexions.entitats.get(i);
			if(email.equals(e.getEmail())){
				verdadero = true;
				Conexions.entitat_conectada = e;
			}
			else{
				i++;
			}
		} while(!verdadero && i < Conexions.entitats.size());

		return verdadero;
	}

	private boolean isEmailValid(String email)
	{
		//TODO: Replace this with your own logic
		return email.contains("@");
	}

	private boolean isPasswordValid(String password)
	{
		//TODO: Replace this with your own logic
		return password.length() > 4;
	}









}

