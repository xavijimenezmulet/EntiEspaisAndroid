package com.example.cep.entiespaisandroid.activities;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.cep.entiespaisandroid.R;

public class VideoActivity extends AppCompatActivity
{

	private VideoView VideoPerfil;
	private Button seleccionarVideo;
	private Button tornarPerfil;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cargar_video_layout);

		seleccionarVideo = (Button)findViewById(R.id.seleccionarVideo);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setTitle("Veure Video");
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setLogo(R.drawable.icono_logo_mas_grande);
		actionBar.setDisplayUseLogoEnabled(true);


		seleccionarVideo.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				cargarVideo();
			}
		});



		Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
		VideoPerfil = (VideoView)findViewById(R.id.VideoPerfil);
		MediaController mc = new MediaController(this);
		VideoPerfil.setMediaController(mc);
		VideoPerfil.setVideoURI(uri);
		VideoPerfil.requestFocus();
		VideoPerfil.start();


	}

	public void cargarVideo(){
		Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		intent.setType("video/");
		startActivityForResult(intent, 1);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Uri path = data.getData();
			VideoPerfil.setVideoURI(path);
		}
	}
}
