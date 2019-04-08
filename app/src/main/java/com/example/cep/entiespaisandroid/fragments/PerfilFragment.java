package com.example.cep.entiespaisandroid.fragments;


import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.activities.MainActivity;
import com.example.cep.entiespaisandroid.activities.VideoActivity;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.EntitatService;
import com.example.cep.entiespaisandroid.classes.ENTITATS;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.example.cep.entiespaisandroid.utilities.Utilitats;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.COMPANION_DEVICE_SERVICE;

public class PerfilFragment extends Fragment
{
	private Button modificarContrassenya;
	private Button Modificar;
	private ImageView ImgPerfil;
	private ImageView ImgCargarPerfil;
	public static Boolean video;
	public static Boolean imagen;
	private Button veureVideo;
	private Button seleccionarImagen;
	private Button seleccionarVideo;
	public static Uri pathVideo;
	private VideoView VideoPerfil;
	private TextView textNomEntitat;
	private TextView textEmailEntitat;
	private TextView textNifEntitat;
	private TextView textAdresaEntitat;
	private TextView textTelefonEntitat;
	private EditText EditText_Pwd1;
	private EditText EditText_Pwd2;
	private EditText EditText_Pwd3;
	private TextView TextView_PwdProblem;
	private EditText EditText_email;
	private EditText EditText_nom;
	private EditText EditText_nif;
	private EditText EditText_adresa;
	private EditText EditText_telefon1;
	private EditText EditText_telefon2;
	private Button acceptarModificar;
	private Button aceptarContrassenyes;


	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_perfil, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		textNomEntitat = (TextView)getView().findViewById(R.id.textNomEntitat);
		textEmailEntitat = (TextView)getView().findViewById(R.id.textEmailEntitat);
		textNifEntitat = (TextView)getView().findViewById(R.id.textNifEntitat);
		textAdresaEntitat = (TextView)getView().findViewById(R.id.textAdresaEntiat);
		textTelefonEntitat= (TextView)getView().findViewById(R.id.textTelefonEntitat);

		textNomEntitat.setText(Conexions.entitat_conectada.getNom());
		textEmailEntitat.setText(Conexions.entitat_conectada.getEmail());
		textNifEntitat.setText(Conexions.entitat_conectada.getNif());
		textAdresaEntitat.setText(Conexions.entitat_conectada.getAdresa());
		textTelefonEntitat.setText("+34" + Conexions.telefons_entitats.get(0).getNumero());

		ImgPerfil = (ImageView)getView().findViewById(R.id.ImgPerfil);
		veureVideo = (Button)getView().findViewById(R.id.veureVideo);

		((MainActivity)getActivity()).changeNavHeaderData();

		imagen = false;
		video = false;
		if(MainActivity.path == null){
			MainActivity.path = (new Uri.Builder())
					.scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
					.authority(getResources().getResourcePackageName(R.drawable.logoprincipal))
					.appendPath(getResources().getResourceTypeName(R.drawable.logoprincipal))
					.appendPath(getResources().getResourceEntryName(R.drawable.logoprincipal))
					.build();
			Picasso.get().load(Conexions.entitat_conectada.getRuta_imagen()).into(ImgPerfil);
		}
		else{
			Picasso.get().load(Conexions.entitat_conectada.getRuta_imagen()).into(ImgPerfil);
		}
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
				View root = getLayoutInflater().inflate(R.layout.password_change_alert, null);
				EditText_Pwd1 = (EditText) root.findViewById(R.id.EditText_Pwd1);
				EditText_Pwd2 = (EditText) root.findViewById(R.id.EditText_Pwd2);
				EditText_Pwd3 = (EditText) root.findViewById(R.id.EditText_Pwd3);
				TextView_PwdProblem = (TextView)root.findViewById(R.id.TextView_PwdProblem);
				aceptarContrassenyes = (Button)root.findViewById(R.id.aceptarContrassenyes);
				builder.setView(root);
				builder.setCancelable(false);
				final AlertDialog a = builder.create();
				builder.setNeutralButton("CANCEL·LAR", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialogInterface, int i)
					{

					}
				});

				aceptarContrassenyes.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View view)
					{
						EditText_Pwd1.setError(null);
						EditText_Pwd2.setError(null);
						EditText_Pwd3.setError(null);


						boolean cancel = false;
						View focusView = null;

						if (EditText_Pwd1.equals(""))
						{
							EditText_Pwd1.setError(getString(R.string.obligatori));
							focusView = EditText_Pwd1;
							cancel = true;
							TextView_PwdProblem.setText(getString(R.string.obligatori));
						} else if (EditText_Pwd2.equals(""))
						{
							EditText_Pwd2.setError(getString(R.string.obligatori));
							focusView = EditText_Pwd2;
							cancel = true;
							TextView_PwdProblem.setText(getString(R.string.obligatori));
						} else if (EditText_Pwd3.equals(""))
						{
							EditText_Pwd3.setError(getString(R.string.obligatori));
							focusView = EditText_Pwd3;
							cancel = true;
							TextView_PwdProblem.setText(getString(R.string.obligatori));
						}
						else if(!Utilitats.verificar(EditText_Pwd1.getText().toString())){
							EditText_Pwd1.setError("La contrassenya no és correcta");
							focusView = EditText_Pwd1;
							cancel = true;
							TextView_PwdProblem.setText("La contrassenya no és correcta");
						}
						else if(!EditText_Pwd2.getText().toString().equals(EditText_Pwd3.getText().toString())){

							EditText_Pwd2.setError("Les Contrassenyes no coincideixen!");
							focusView = EditText_Pwd2;
							cancel = true;
							EditText_Pwd3.setError("Les Contrassenyes no coincideixen!");
							TextView_PwdProblem.setText("Les Contrassenyes no coincideixen!");
						}
						else{
							final ProgressDialog progressDialog = new ProgressDialog(getActivity());
							progressDialog.setIcon(R.mipmap.ic_launcher_entiespais);
							progressDialog.setMessage("Guardant dades...");
							progressDialog.show();
							Conexions.entitat_conectada.setContrassenya(Utilitats.encriptar(EditText_Pwd2.getText().toString()));

							EntitatService es = Api.getApi().create(EntitatService.class);

							Call<ENTITATS> e = es.updateEntitat(Conexions.entitat_conectada.getId(), Conexions.entitat_conectada);

							e.enqueue(new Callback<ENTITATS>()
							{
								@Override
								public void onResponse(Call<ENTITATS> call, Response<ENTITATS> response)
								{
									progressDialog.dismiss();
									a.cancel();
								}

								@Override
								public void onFailure(Call<ENTITATS> call, Throwable t)
								{
									progressDialog.dismiss();
								}
							});

						}

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
				final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setTitle("Modificar Perfil");
				builder.setIcon(R.drawable.icono_logo);
				View root = getLayoutInflater().inflate(R.layout.modificar_perfil_alert, null);
				EditText_nom = (EditText) root.findViewById(R.id.EditText_nom);
				EditText_email = (EditText) root.findViewById(R.id.EditText_email);
				EditText_nif = (EditText) root.findViewById(R.id.EditText_nif);
				EditText_adresa = (EditText) root.findViewById(R.id.EditText_adresa);
				EditText_telefon1 = (EditText) root.findViewById(R.id.EditText_telefon1);
				EditText_telefon2 = (EditText)root.findViewById(R.id.EditText_telefon2);
				acceptarModificar = (Button)root.findViewById(R.id.acceptarModificar);
				EditText_nom.setText(Conexions.entitat_conectada.getNom().toString());
				EditText_email.setText(Conexions.entitat_conectada.getEmail().toString());
				EditText_nif.setText(Conexions.entitat_conectada.getNif().toString());
				EditText_adresa.setText(Conexions.entitat_conectada.getAdresa().toString());
				/**
				EditText_telefon1.setText(Conexions.entitat_conectada.telefons_entitats.get(0).getNumero().toString());
				if(Conexions.entitat_conectada.telefons_entitats.size()>1)
				{
					EditText_telefon2.setText(Conexions.entitat_conectada.getNom().toString());
				}
				 **/
				builder.setView(root);
				builder.setCancelable(false);
				builder.setNeutralButton("CANCEL·LAR", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialogInterface, int i)
					{

					}
				});
				acceptarModificar.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View view)
					{
						EditText_nom.setError(null);
						EditText_email.setError(null);
						EditText_nif.setError(null);
						EditText_adresa.setError(null);
						EditText_telefon1.setError(null);
						EditText_telefon2.setError(null);

						String nom = EditText_nom.getText().toString();
						String email = EditText_email.getText().toString();
						String nif = EditText_nif.getText().toString();
						String adresa = EditText_adresa.getText().toString();
						String telefon1 = EditText_telefon1.getText().toString();
						String telefon2 = EditText_telefon2.getText().toString();

						boolean cancel = false;
						View focusView = null;

						if (nom.equals(""))
						{
							EditText_nom.setError(getString(R.string.obligatori));
							focusView = EditText_nom;
							cancel = true;
						} else if (email.equals(""))
						{
							EditText_email.setError(getString(R.string.obligatori));
							focusView = EditText_email;
							cancel = true;
						} else if (nif.equals(""))
						{
							EditText_nif.setError(getString(R.string.obligatori));
							focusView = EditText_nif;
							cancel = true;
						} else if (adresa.equals(""))
						{
							EditText_adresa.setError(getString(R.string.obligatori));
							focusView = EditText_adresa;
							cancel = true;
						} else if (telefon1.equals("") && !Utilitats.isNumeric(telefon1) && telefon1.length() != 9)
						{

							EditText_telefon1.setError(getString(R.string.obligatori));
							focusView = EditText_telefon1;
							cancel = true;
						}
						else if(!email.contains("@")){
							EditText_email.setError("Email incorrecte!");
							focusView = EditText_email;
							cancel = true;
						}
						else{
							final ProgressDialog progressDialog = new ProgressDialog(getActivity());
							progressDialog.setIcon(R.mipmap.ic_launcher_entiespais);
							progressDialog.setMessage("Guardant dades...");
							progressDialog.show();
							Conexions.entitat_conectada.setNom(EditText_nom.getText().toString());
							Conexions.entitat_conectada.setEmail(EditText_email.getText().toString());
							Conexions.entitat_conectada.setNif(EditText_nif.getText().toString());
							Conexions.entitat_conectada.setAdresa(EditText_adresa.getText().toString());
							textNomEntitat.setText(Conexions.entitat_conectada.getNom());
							textEmailEntitat.setText(Conexions.entitat_conectada.getEmail());
							textNifEntitat.setText(Conexions.entitat_conectada.getNif());
							textAdresaEntitat.setText(Conexions.entitat_conectada.getAdresa());
							/**
							Conexions.entitat_conectada.telefons_entitats.get(0).setNumero(EditText_nom.getText().toString());
							if(EditText_telefon2.getText().toString().equals("")){
								Conexions.entitat_conectada.telefons_entitats.get(1).setNumero(EditText_nom.getText().toString());
							}
							**/
							EntitatService es = Api.getApi().create(EntitatService.class);

							Call<ENTITATS> e = es.updateEntitat(Conexions.entitat_conectada.getId(), Conexions.entitat_conectada);

							e.enqueue(new Callback<ENTITATS>()
							{
								@Override
								public void onResponse(Call<ENTITATS> call, Response<ENTITATS> response)
								{
									progressDialog.dismiss();
								}

								@Override
								public void onFailure(Call<ENTITATS> call, Throwable t)
								{
									progressDialog.dismiss();
								}
							});
						}
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
				View root = getLayoutInflater().inflate(R.layout.cargar_imagen_layout, null);
				ImgCargarPerfil = (ImageView) root.findViewById(R.id.ImgCargarPerfil);
				seleccionarImagen = (Button) root.findViewById(R.id.seleccionarImagen);
				Picasso.get().load(Conexions.entitat_conectada.getRuta_imagen()).into(ImgCargarPerfil);
				builder.setView(root);
				builder.setCancelable(false);
				builder.setNeutralButton("CANCEL·LAR", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialogInterface, int i)
					{

					}
				});
				seleccionarImagen.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View view)
					{
						imagen = true;
						cargarImagen();

						((MainActivity)getActivity()).changeNavHeaderData();
						Picasso.get().load(Conexions.entitat_conectada.getRuta_imagen()).into(ImgCargarPerfil);


					}
				});
				builder.show();


			}
		});

		veureVideo.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{

				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setTitle("Veure Video");
				builder.setIcon(R.drawable.icono_logo);
				View root = getLayoutInflater().inflate(R.layout.cargar_video_layout, null);
				VideoPerfil = (VideoView) root.findViewById(R.id.VideoPerfil);
				seleccionarVideo = (Button) root.findViewById(R.id.seleccionarVideo);
				VideoPerfil.setVideoURI(pathVideo);
				VideoPerfil.setZOrderOnTop(true);
				builder.setView(root);
				builder.setCancelable(false);
				if(pathVideo == null){
					Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
					//MediaController mc = new MediaController(root.getContext());
					//VideoPerfil.setMediaController(mc);
					VideoPerfil.setZOrderOnTop(true);
					VideoPerfil.setVideoURI(uri);
					VideoPerfil.requestFocus();
					VideoPerfil.start();
				}
				else{
					//MediaController mc = new MediaController(root.getContext());
					//VideoPerfil.setMediaController(mc);
					VideoPerfil.setZOrderOnTop(true);
					VideoPerfil.setVideoURI(pathVideo);
					VideoPerfil.requestFocus();
					VideoPerfil.start();
				}
				builder.setNeutralButton("CANCEL·LAR", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialogInterface, int i)
					{

					}
				});
				seleccionarVideo.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View view)
					{
						video = true;
						cargarVideo();
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
		if(resultCode == RESULT_OK && imagen){
			Conexions.entitat_conectada.setRuta_imagen(data.getData().toString());
			Picasso.get().load(Conexions.entitat_conectada.getRuta_imagen()).into(ImgPerfil);
			Picasso.get().load(Conexions.entitat_conectada.getRuta_imagen()).into(ImgCargarPerfil);
			imagen = false;

			((MainActivity)getActivity()).changeNavHeaderData();

		}
		if(resultCode == RESULT_OK && video){
			pathVideo = data.getData();
			VideoPerfil.setZOrderOnTop(true);
			VideoPerfil.setVideoURI(pathVideo);
			VideoPerfil.requestFocus();
			VideoPerfil.start();
			video = false;
		}
	}

	public void cargarVideo(){
		Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		intent.setType("video/");
		startActivityForResult(intent, 1);

	}


}
