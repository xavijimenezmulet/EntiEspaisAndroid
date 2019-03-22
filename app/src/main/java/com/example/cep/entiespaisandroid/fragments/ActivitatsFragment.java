package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

public class ActivitatsFragment extends Fragment
{
	private ListView listaActs;
	private ActivitatsFragment.ActivitatsListener listener;
	private ImageView ImgPrincipal;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_activitats, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state)
	{
		super.onActivityCreated(state);

		ImgPrincipal = (ImageView) getView().findViewById(R.id.ImgPrincipalAct);
		ImgPrincipal.setImageResource(R.drawable.logoprincipal);

		listaActs = (ListView) getView().findViewById(R.id.lstActs);

		listaActs.setAdapter(new ActivitatsFragment.AdaptadorActivitats(this));

		listaActs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
				if (listener!=null) {
					listener.onEnvironmentSeleccionado(
							(ACTIVITATS) listaActs.getAdapter().getItem(pos));
				}
			}
		});
	}
	public interface ActivitatsListener {
		void onEnvironmentSeleccionado(ACTIVITATS a);
	}

	public void setActivitatsListener(ActivitatsFragment.ActivitatsListener listener) {
		this.listener=listener;
	}

	class AdaptadorActivitats extends ArrayAdapter<ACTIVITATS>
	{

		Activity context;

		AdaptadorActivitats(Fragment context) {
			super(context.getActivity(), R.layout.item_activitats);
			this.context = context.getActivity();
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.item_activitats, null);

			TextView Nom = (TextView)item.findViewById(R.id.textNomAct);
			Nom.setText(Conexions.activitats.get(position).getNom());

			int idDemanda = Conexions.activitats.get(position).getId_demanda_act();
			int posDem = -1;
			for(int i = 0; i < Conexions.demanda_acts.size(); i++)
			{
				if(idDemanda == Conexions.demanda_acts.get(i).getId_equip())
				{
					posDem = i;
				}
			}

			TextView NomEquip = (TextView)item.findViewById(R.id.textNomEquipAct);
			int idEquip = Conexions.demanda_acts.get(posDem).getId_equip();
			int pos = -1;
			for(int i = 0; i < Conexions.equips.size(); i++)
			{
				if(Conexions.equips.get(i).getId() == idEquip)
				{
					pos = i;
				}
			}
			NomEquip.setText(Conexions.equips.get(pos).getNom());

			int idInterval = Conexions.demanda_acts.get(posDem).getId_interval_hores();

			for(int i = 0; i < Conexions.hores.size(); i++)
			{
				if(Conexions.hores.get(i).getId() == idInterval)
				{
					pos = i;
				}
			}

			TextView horaInici = (TextView)item.findViewById(R.id.txtHoraIniAct);
			horaInici.setText(Conexions.hores.get(pos).getInici().toString());
			TextView horaFi = (TextView)item.findViewById(R.id.txtHoraFiAct);
			horaFi.setText(Conexions.hores.get(pos).getFi().toString());
			ListView listaDiesAct = (ListView) item.findViewById(R.id.lstDiesAct);
			ArrayList<String> dies = new ArrayList<>();

			int idDem = Conexions.demanda_acts.get(posDem).getId();
			for(int i = 0; i < Conexions.dias_demanda.size(); i++)
			{
				if(Conexions.dias_demanda.get(i).getId_demanda_act() == idDem)
				{
					for(int j = 0; j < Conexions.dies_setmana.size(); j++)
					{
						if(Conexions.dias_demanda.get(i).getId_dia_setmana() == Conexions.dies_setmana.get(j).getId())
						{
							dies.add(Conexions.dies_setmana.get(j).getNom());
						}
					}
				}
			}
			ArrayAdapter<String> adapter =
					new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, dies);
			listaDiesAct.setAdapter(adapter);

			return(item);
		}
	}
}
