package com.example.cep.entiespaisandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.ActivitatsService;
import com.example.cep.entiespaisandroid.api.apiService.Demanda_ActService;
import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.ESPAIS;
import com.example.cep.entiespaisandroid.classes.HORES;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitatFragment extends Fragment
{
	private ImageView ImgPrincipal;
	private TextView nomActivitat;
	private TextView equipAct;
	private TextView horaIniAct;
	private TextView horaFiAct;
	private TextView instalAct;
	private TextView espaiAct;
	private ListView lstDias;
	private Button btnEliminar;
	private ArrayList<DIA_SEMANA> days = new ArrayList<>();
	private ACTIVITATS activitat = new ACTIVITATS();
	private DEMANDA_ACT demand = new DEMANDA_ACT();

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_activitat, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state)
	{
		super.onActivityCreated(state);


		Bundle bundle = getArguments();
		activitat= (ACTIVITATS) bundle.getSerializable("ACT");

		nomActivitat = (TextView) getView().findViewById(R.id.nomActivitat);
		equipAct = (TextView) getView().findViewById(R.id.equipAct);
		horaIniAct = (TextView) getView().findViewById(R.id.horaIniAct);
		horaFiAct = (TextView) getView().findViewById(R.id.horaFiAct);
		instalAct = (TextView) getView().findViewById(R.id.instalAct);
		espaiAct = (TextView) getView().findViewById(R.id.espaiAct);
		lstDias = (ListView) getView().findViewById(R.id.lstDiasAct);
		btnEliminar = (Button) getView().findViewById(R.id.btnEliminar);

		btnEliminar.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				//--delete-----------------
				ActivitatsService as = Api.getApi().create(ActivitatsService.class);

				Call<ACTIVITATS> act = as.DeleteActivitat(activitat.getId());

				act.enqueue(new Callback<ACTIVITATS>()
				{
					@Override
					public void onResponse(Call<ACTIVITATS> call, Response<ACTIVITATS> response)
					{
						switch (response.code())
						{
							case 200:
								Toast.makeText(getActivity(), "Demanda Eliminada", Toast.LENGTH_SHORT).show();
								break;
							default:
								break;
						}
					}

					@Override
					public void onFailure(Call<ACTIVITATS> call, Throwable t)
					{
						Toast.makeText(getActivity(), "HA IDO MAL", Toast.LENGTH_LONG).show();
					}
				});
				//----------------------

				FragmentManager fragmentManager = getFragmentManager ();

				Fragment frag = new ActivitatsFragment();

				FragmentTransaction ft = fragmentManager.beginTransaction();
				ft.replace(R.id.fragment_content, frag);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();
			}
		});

		for(DEMANDA_ACT dem : Conexions.demanda_acts)
		{
			if(dem.getId() == activitat.getId_demanda_act())
			{
				demand = dem;
			}
		}
		nomActivitat.setText(activitat.getNom());

		EQUIPS e = new EQUIPS();
		for(int i = 0; i < Conexions.equips.size(); i++)
		{
			if(Conexions.equips.get(i).getId() == demand.getId_equip())
			{
				e = Conexions.equips.get(i);
			}
		}
		equipAct.setText(e.getNom());

		HORES hora = new HORES();
		for(int i = 0; i < Conexions.hores.size(); i++)
		{
			if(Conexions.hores.get(i).getId() == demand.getId_interval_hores())
			{
				hora = Conexions.hores.get(i);
			}
		}
		horaIniAct.setText(hora.getInici());
		horaFiAct.setText(hora.getFi());

		ESPAIS esp = new ESPAIS();
		for(int i = 0; i < Conexions.espais.size(); i++)
		{
			if(Conexions.espais.get(i).getId() == demand.getId_espai())
			{
				esp = Conexions.espais.get(i);
			}
		}

		INSTALACIONS inst = new INSTALACIONS();
		for(int i = 0; i < Conexions.instalacions.size(); i++)
		{
			if(Conexions.instalacions.get(i).getId() == esp.getId_instalacio())
			{
				inst = Conexions.instalacions.get(i);
			}
		}
		instalAct.setText(inst.getNom());
		espaiAct.setText(esp.getNom());

		ArrayList<String> dias = new ArrayList<>();
		if(demand.getDia_semanas() != null) {
			for (DIA_SEMANA dia : demand.getDia_semanas()) {
				dias.add(dia.getNom());
			}
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,dias);
		lstDias.setAdapter(adapter);
	}
}
