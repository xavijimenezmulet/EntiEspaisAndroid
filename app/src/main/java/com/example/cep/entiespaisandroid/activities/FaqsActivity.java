package com.example.cep.entiespaisandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.cep.entiespaisandroid.R;

public class FaqsActivity extends AppCompatActivity
{

	private ImageView ImgLogo1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faqs);

		ImgLogo1 = (ImageView)findViewById(R.id.ImgLogo1);
	}
}
