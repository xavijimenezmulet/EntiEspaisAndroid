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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.Demanda_ActService;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.ESPAIS;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

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
	private ArrayList<String> nEquips = new ArrayList<>();
	private ArrayList<String> instalacions = new ArrayList<>();
	private ArrayList<String> espais = new ArrayList<>();
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
				nEquips.add(e.getNom());
			}
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, instalacions);
		introEquipDem.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, nEquips));

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
						espais.add(e.getNom());
					}
				}
				ArrayAdapter<String> adapterEsp = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, espais);
				espaiDem.setAdapter(adapterEsp);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {
				// Toast
			}
		});
	}
}
