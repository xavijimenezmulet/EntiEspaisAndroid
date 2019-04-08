package com.example.cep.entiespaisandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.adapters.ListFaqsAdapter;
import com.example.cep.entiespaisandroid.utilities.Conexions;

public class FaqsActivity extends AppCompatActivity
{

	private ListView ListFaqs;
	private ImageView ImgLogo1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faqs);

		ImgLogo1 = (ImageView)findViewById(R.id.ImgLogo1);
		ImgLogo1.setImageResource(R.drawable.logoprincipal);

		ListFaqs = (ListView)findViewById(R.id.ListFaqs);

		ListFaqsAdapter lf = new ListFaqsAdapter(this, Conexions.faqs);

		ListFaqs.setAdapter(lf);


	}
}
