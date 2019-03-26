package com.example.cep.entiespaisandroid.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.activities.MainActivity;

import static android.app.Activity.RESULT_OK;

public class PerfilFragment extends Fragment
{
	private Button modificarContrassenya;
	private Button Modificar;
	private ImageView ImgPerfil;
	private Button CarregarButton;
	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_perfil, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);

		ImgPerfil = (ImageView)getView().findViewById(R.id.ImgPerfil);
		CarregarButton = (Button)getView().findViewById(R.id.CarregarButton);
		modificarContrassenya = (Button)getView().findViewById(R.id.modificarContrasenya);
		Modificar = (Button)getView().findViewById(R.id.Modificar);
		modificarContrassenya.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{

				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setTitle(Html.fromHtml("<font color ='#000000'>Canviar Contrassenya</font>"));
				builder.setIcon(R.drawable.icono_logo);
				builder.setView(R.layout.password_change_alert);


				builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

					}
				});

				builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

					}
				});

				builder.show();
			}
		});

		Modificar.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setTitle("Modificar Perfil");
				builder.setIcon(R.drawable.icono_logo);
				builder.setView(R.layout.modificar_perfil_alert);

				builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

					}
				});

				builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

					}
				});

				builder.show();
			}
		});

		ImgPerfil.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setTitle("Carregar Imatge");
				builder.setIcon(R.drawable.icono_logo);
				builder.setView(R.layout.cargar_imagen_layout);
				builder.setNeutralButton("CANCEL·LAR", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialogInterface, int i)
					{

					}
				});
				builder.setNegativeButton("GUARDAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

					}
				});

				builder.setPositiveButton("SELECCIONA IMATGE", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						cargarImagen();
					}
				});
				builder.show();

			}
		});

	}

	public void cargarImagen(){
		Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		intent.setType("image/");
		startActivityForResult(intent, 1);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Uri path = data.getData();
			ImgPerfil.setImageURI(path);
		}
	}
}
