package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.activities.SplashActivity;
import com.example.cep.entiespaisandroid.adapters.SpinAdapterEquips;
import com.example.cep.entiespaisandroid.adapters.SpinAdapterEspais;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.Demanda_ActService;
import com.example.cep.entiespaisandroid.api.apiService.EquipService;
import com.example.cep.entiespaisandroid.api.apiService.HoresService;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.ESPAIS;
import com.example.cep.entiespaisandroid.classes.HORES;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;
import com.example.cep.entiespaisandroid.classes.MensajeError;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.example.cep.entiespaisandroid.utilities.ProcesApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DemandaFragment extends Fragment
{
	private ImageView ImgPrincipal;
	private EditText introNomDem;
	private Spinner introEquipDem;
	private EditText iniciDem;
	private EditText fiDem;
	private Spinner instalDem;
	private Spinner espaiDem;
	private Button aceptar;
	private Button cancelar;
	private ArrayList<EQUIPS> nEquips = new ArrayList<>();
	private ArrayList<String> instalacions = new ArrayList<>();
	private ArrayList<ESPAIS> espais = new ArrayList<>();
	private int idEquip;
	private SpinAdapterEquips adapter;
	private SpinAdapterEspais adapterEsp;
	private EQUIPS selectedEquip;
	private ESPAIS selectedEspai;
	private CheckBox dilluns;
	private CheckBox dimarts;
	private CheckBox dimecres;
	private CheckBox dijous;
	private CheckBox divendres;
	private CheckBox dissabte;
	private CheckBox diumenge;
	private int id;
	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_demanda, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state)
	{
		super.onActivityCreated(state);

		ImgPrincipal = (ImageView) getView().findViewById(R.id.ImgPrincipal);
		ImgPrincipal.setImageResource(R.drawable.logoprincipal);
		introNomDem = (EditText) getView().findViewById(R.id.introNomDem);
		introEquipDem = (Spinner) getView().findViewById(R.id.introEquipDem);
		iniciDem = (EditText) getView().findViewById(R.id.introIniciDem);
		fiDem = (EditText) getView().findViewById(R.id.introFiDem);
		instalDem = (Spinner) getView().findViewById(R.id.introInstalDem);
		espaiDem = (Spinner) getView().findViewById(R.id.introEspaiDem);
		aceptar = (Button) getView().findViewById(R.id.btnAceptDem);
		cancelar = (Button) getView().findViewById(R.id.btnCancelDem);
		dilluns = (CheckBox) getView().findViewById(R.id.dilluns);
		dimarts = (CheckBox) getView().findViewById(R.id.dimarts);
		dimecres = (CheckBox) getView().findViewById(R.id.dimecres);
		dijous = (CheckBox) getView().findViewById(R.id.dijous);
		divendres = (CheckBox) getView().findViewById(R.id.divendres);
		dissabte = (CheckBox) getView().findViewById(R.id.dissabte);
		diumenge = (CheckBox) getView().findViewById(R.id.diumenge);

		cancelar.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{

				FragmentManager fragmentManager = getFragmentManager ();

				Fragment frag = new PrincipalFragment();

				FragmentTransaction ft = fragmentManager.beginTransaction();
				ft.replace(R.id.fragment_content, frag);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();
			}
		});

		for(EQUIPS e : Conexions.equips) {
			if(e.getId_entitat() == Conexions.entitat_conectada.getId())
			{
				nEquips.add(e);
			}
		}

		adapter = new SpinAdapterEquips(getActivity(),
				android.R.layout.simple_spinner_item,
				nEquips);
		introEquipDem.setAdapter(adapter);
		introEquipDem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view,
									   int position, long id) {

				selectedEquip = adapter.getItem(position);
			}
			@Override
			public void onNothingSelected(AdapterView<?> adapter) {  }
		});
//---------------------------------
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, instalacions);

		for(INSTALACIONS i : Conexions.instalacions)
		{
			instalacions.add(i.getNom());
		}
		instalDem.setAdapter(adapter);

		instalDem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
				if(espais != null)
				{
					espais.clear();
				}
				for(ESPAIS e : Conexions.espais)
				{
					if(e.getId_instalacio() == Conexions.instalacions.get(position).getId())
					{
						espais.add(e);
					}
				}
				adapterEsp = new SpinAdapterEspais(getActivity(),
						android.R.layout.simple_spinner_item,
						espais);
				espaiDem.setAdapter(adapterEsp);
				espaiDem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> adapterView, View view,
											   int position, long id) {

						selectedEspai = adapterEsp.getItem(position);
					}
					@Override
					public void onNothingSelected(AdapterView<?> adapter) {  }
				});
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {
				// Toast
			}
		});
		aceptar.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{

				if(!iniciDem.getText().toString().matches("\\d{2}:\\d{2}") || !fiDem.getText().toString().matches("\\d{2}:\\d{2}") )
				{
					Toast.makeText(getActivity(), "Horari incorrecte!", Toast.LENGTH_LONG).show();
				}
				else {
					final HORES horari = new HORES();
					horari.setInici(iniciDem.getText() + ":00.0000000");
					horari.setFi(fiDem.getText() + ":00.0000000");
					if(!dilluns.isChecked() && !dimarts.isChecked() && !dimecres.isChecked() && !dijous.isChecked() && !divendres.isChecked() && !dissabte.isChecked() && !diumenge.isChecked())
					{
						Toast.makeText(getActivity(), "Selecciona algun dia!", Toast.LENGTH_LONG).show();
					}
					else {
						//Insertar horari a la taula hores
						final DEMANDA_ACT demanda = new DEMANDA_ACT();
						demanda.setNom(introNomDem.getText().toString());
						demanda.setId_equip(selectedEquip.getId());
						demanda.setId_espai(selectedEspai.getId());
						ArrayList<DIA_SEMANA> dies = new ArrayList<>();
						int ndies = 0;
						if(dilluns.isChecked())
						{
							dies.add(Conexions.dies_setmana.get(0));
							ndies++;
						}
						if(dimarts.isChecked())
						{
							dies.add(Conexions.dies_setmana.get(1));
							ndies++;
						}
						if(dimecres.isChecked())
						{
							dies.add(Conexions.dies_setmana.get(2));
							ndies++;
						}
						if(dijous.isChecked())
						{
							dies.add(Conexions.dies_setmana.get(3));
							ndies++;
						}
						if(divendres.isChecked())
						{
							dies.add(Conexions.dies_setmana.get(4));
							ndies++;
						}
						if(dissabte.isChecked())
						{
							dies.add(Conexions.dies_setmana.get(5));
							ndies++;
						}
						if(diumenge.isChecked())
						{
							dies.add(Conexions.dies_setmana.get(6));
							ndies++;
						}
						demanda.setDia_semanas(dies);
						demanda.setEs_asignada(false);
						demanda.setNum_dies((byte)ndies);
						demanda.setNum_espais((byte)1);
						id = Conexions.hores.get(Conexions.hores.size()-1).getId() + 1;

						//---------------INSERT ASYNC

						HoresService horesService = Api.getApi().create(HoresService.class);
						Call<HORES> horesCall = horesService.InsertHores(horari);

						horesCall.enqueue(new Callback<HORES>()
						{
							@Override
							public void onResponse(Call<HORES> call, Response<HORES> response)
							{
								switch (response.code())
								{
									case 201:
										break;
									case 400:
										Gson gson = new Gson();
										MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
										Toast.makeText(getContext(), mensajeError.getMessage(), Toast.LENGTH_LONG).show();
										break;
								}
							}

							@Override
							public void onFailure(Call<HORES> call, Throwable t)
							{
								Toast.makeText(getContext(), t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
							}
						});


						Conexions.hores.add(new HORES(id, horari.getInici().substring(0,8),horari.getFi().substring(0,8)));
						demanda.setId_interval_hores(id);
						//------------------INSERT DEMANDA-----------------------------

						ArrayList<ProcesApi> processos = new ArrayList<>();
						try
						{
							Conexions.demanda_acts.add(demanda);
							ProcesApi p = new ProcesApi(demanda, 2);
							p.start();
							processos.add(p);
							ProcesApi p2 = new ProcesApi(1);
							processos.add(p2);

							for(int i = 0; i < processos.size(); i++)
							{
								processos.get(i).join(0);
							}
							Toast.makeText(getContext(), "Demanda efectuada amb exit!", Toast.LENGTH_LONG).show();
						}catch(Exception e)
						{
							System.out.println(e);
						}

						//-----------------------------------------------------
						FragmentManager fragmentManager = getFragmentManager();

						Fragment frag = new PrincipalFragment();

						FragmentTransaction ft = fragmentManager.beginTransaction();
						ft.replace(R.id.fragment_content, frag);
						ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
						ft.addToBackStack(null);
						ft.commit();
					}
				}
			}
		});
	}
}
