package com.example.cep.entiespaisandroid.fragments;


import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.adapters.ListaActivitatsAdapter;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.EquipService;
import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.MensajeError;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EquipsFragment extends Fragment
{
	private RecyclerView mRecyClerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private ArrayList<EQUIPS> equipss = new ArrayList<EQUIPS>();
	private ArrayList<EQUIPS> equipsList;

	private void rellenarEquipos() {
		EquipService equipService = Api.getApi().create(EquipService.class);

		Call<ArrayList<EQUIPS>> listCall = equipService.getEquips();

		listCall.enqueue(new Callback<ArrayList<EQUIPS>>() {
			@Override
			public void onResponse(Call<ArrayList<EQUIPS>> call, Response<ArrayList<EQUIPS>> response) {
				switch(response.code()) {
					case 200:
						Conexions.equips = response.body();
						break;
					case 400:
						Toast.makeText(getActivity(), response.message().toString(), Toast.LENGTH_LONG).show();
						break;
					case 503:
						Toast.makeText(getActivity(), response.message().toString(), Toast.LENGTH_LONG).show();
						break;
					default:
						break;
				}
			}

			@Override
			public void onFailure(Call<ArrayList<EQUIPS>> call, Throwable t) {
				Toast.makeText(getActivity(), t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});
	}

	private void mostrarDialogEquipo() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		View root = getLayoutInflater().inflate(
				(R.layout.alert_dialog_equips), null);
		builder.setView(root);

		final EditText editTextNombre = root.findViewById(R.id.etxt_nombre);
		//Añadir spinners
		builder.setTitle("Afegir equip");

		builder.setPositiveButton("Acceptar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				EQUIPS equip = new EQUIPS();
				equip.setNom(editTextNombre.getText().toString());
				//..

				EquipService equipService = Api.getApi().create(EquipService.class);
				Call<EQUIPS> equipCall = equipService.insertEquip(equip);

				equipCall.enqueue(new Callback<EQUIPS>()
				{
					@Override
					public void onResponse(Call<EQUIPS> call, Response<EQUIPS> response)
					{
						switch (response.code()){
							case 201:
								rellenarEquipos();
								break;
							case 400:
								Gson gson = new Gson();
								MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
								Toast.makeText(getContext(), mensajeError.getMessage(), Toast.LENGTH_LONG).show();
								break;
						}
					}

					@Override
					public void onFailure(Call<EQUIPS> call, Throwable t)
					{
						Toast.makeText(getContext(), t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
					}
				});
			}
		});

		AlertDialog alertDialog = builder.create();
		alertDialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));
		alertDialog.show();
	}

	protected void mostrarDialogBorrarEquipo(final EQUIPS equip2) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		View root = getLayoutInflater().inflate(
				(R.layout.alert_dialog_borrar), null);
		builder.setView(root);

		TextView textView = root.findViewById(R.id.txt_mensaje);
		textView.setText("Estàs segur d'eliminar aquest equip?");

		builder.setTitle("Eliminar equip: " + equip2.getNom());
		builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				EquipService equipService = Api.getApi().create(EquipService.class);

				Call<EQUIPS> equipCall = equipService.deleteEquip(equip2.getId());
				equipCall.enqueue(new Callback<EQUIPS>()
				{
					@Override
					public void onResponse(Call<EQUIPS> call, Response<EQUIPS> response)
					{
						switch (response.code()){
							case 201:
								rellenarEquipos();
								break;
							case 400:
								Gson gson = new Gson();
								MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
								Toast.makeText(getContext(), mensajeError.getMessage(), Toast.LENGTH_LONG).show();
								break;
							case 404:
								Toast.makeText(getContext(), "No s'ha trobat el registre", Toast.LENGTH_LONG).show();
								break;
						}
					}
					@Override
					public void onFailure(Call<EQUIPS> call, Throwable t)
					{
						Toast.makeText(getContext(), t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
					}
				});
			}
		});


		AlertDialog alertDialog = builder.create();
		alertDialog.show();
	}


	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_equips, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);

		mRecyClerView = getView().findViewById(R.id.rv_recycler_view);

		mRecyClerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(getContext());


		mAdapter = new AdaptadorEquips(Conexions.equips);

		((AdaptadorEquips) mAdapter).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final int position_eq = mRecyClerView.getChildAdapterPosition(v);
				final EQUIPS equip = Conexions.equips.get(position_eq);

				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setTitle(equip.getNom());
				builder.setIcon(R.drawable.icono_logo);
				View root = getLayoutInflater().inflate(
						(R.layout.alert_dialog_equips), null);
				EditText editText = root.findViewById(R.id.etxt_nombre);
				editText.setText(equip.getNom());

				CheckBox checkboxDiscapacidad = root.findViewById(R.id.cb_si);

				if (equip.getTe_discapacitat())
				{
					checkboxDiscapacidad.setChecked(true);
				}
				builder.setView(root);

				builder.setNegativeButton("ELIMINAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						equipsList.remove(position_eq);
						mAdapter.notifyItemRemoved(position_eq);
						mAdapter.notifyItemRangeChanged(position_eq, equipsList.size());
					}
				});

				builder.setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

					}
				});

				builder.setNeutralButton("VER ACTIVIDADES", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialogInterface, int i)
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
						builder.setTitle(equip.getNom());
						builder.setIcon(R.drawable.icono_logo);
						View root = getLayoutInflater().inflate(
								(R.layout.alert_dialog_activitats), null);
						ArrayList<ACTIVITATS> activitats = new ArrayList<>();
						for (int j = 0; j < 20; j++) {
							activitats.add(new ACTIVITATS(1, "Actividad9293", 2, 3, 4));
						}
						ListView listview = root.findViewById(R.id.lv_activitats);
						ListaActivitatsAdapter adapter = new ListaActivitatsAdapter(getContext(), activitats);
						listview.setAdapter(adapter);
						builder.setView(root);
						AlertDialog dlg = builder.show();
						dlg.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));
					}
				});


				AlertDialog dlg = builder.show();
				dlg.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));


			}
		});

		mRecyClerView.setLayoutManager(mLayoutManager);
		mRecyClerView.setAdapter(mAdapter);

		Button btn_afegir = getView().findViewById(R.id.añadirEquipo);
		btn_afegir.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				mostrarDialogEquipo();
			}
		});


	}



	class AdaptadorEquips extends RecyclerView.Adapter <AdaptadorEquips.EquipViewHolder>
			implements View.OnClickListener
	{
		private View.OnClickListener listener;
		ArrayList<EQUIPS> equipos;


		public AdaptadorEquips(ArrayList<EQUIPS> lista_equipos) {
			this.equipos = lista_equipos;
		}
		class EquipViewHolder
				extends RecyclerView.ViewHolder
		{
			private ImageView imgEquipImage;
			private TextView lblEquipName;
			private TextView lblEquipEsport;


			public EquipViewHolder(View itemView)
			{
				super(itemView);
				imgEquipImage = itemView.findViewById(R.id.iv_image);
				lblEquipName = itemView.findViewById(R.id.tv_text);
				lblEquipEsport = itemView.findViewById(R.id.tv_blah);
			}

			public void bindEquip(EQUIPS e) {
				imgEquipImage.setImageResource(R.drawable.ic_action_equips);
				lblEquipName.setText(e.getNom());
				lblEquipEsport.setText(/*Buscar nombre del deporte por id*/String.valueOf(e.getId_esport()));
			}
		}

		@NonNull
		@Override
		public EquipViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
		{
			View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item,
					viewGroup, false);

			itemView.setOnClickListener(this);

			EquipViewHolder evh = new EquipViewHolder(itemView);
			return evh;
		}
		@Override
		public void onBindViewHolder(@NonNull EquipViewHolder equipViewHolder, int i)
		{
			EQUIPS item = equipos.get(i);
			equipViewHolder.bindEquip(item);
		}

		@Override
		public int getItemCount()
		{
			return equipos.size();
		}

		public void setOnClickListener(View.OnClickListener listener) {
			this.listener = listener;
		}

		@Override
		public void onClick(View view) {
			if(listener != null) {
				listener.onClick(view);

			}


		}

	}


}
