package com.example.cep.entiespaisandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cep.entiespaisandroid.R;

public class SignUpActivity extends AppCompatActivity
{

	private Button cancelarButton;
	private ImageView ImgSignUp;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);

		cancelarButton = (Button)findViewById(R.id.cancelarButton);
		ImgSignUp = (ImageView)findViewById(R.id.ImgSignup);
		ImgSignUp.setImageResource(R.drawable.logoprincipal);

		cancelarButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				finish();
			}
		});

	}
}
