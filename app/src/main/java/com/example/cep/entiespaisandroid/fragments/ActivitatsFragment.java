package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

public class ActivitatsFragment extends Fragment
{
	private RecyclerView listaActs;
	private ActivitatsFragment.ActivitatsListener listener;
	private ImageView ImgPrincipal;
	private Button btnAct;
	private Fragment fragment;
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
		btnAct = (Button) getView().findViewById(R.id.btnAct);

		btnAct.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				FragmentManager fragmentManager = getFragmentManager ();

				Fragment frag = new ActivitatFragment();

				FragmentTransaction ft = fragmentManager.beginTransaction();
				ft.replace(R.id.fragment_content, frag);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();
			}
		});

		listaActs = (RecyclerView) getView().findViewById(R.id.lstActs);


		final ArrayList<ACTIVITATS> activitats = new ArrayList<>();

		for(EQUIPS e : Conexions.equips)
		{
			if(e.getId_entitat() == Conexions.getEntitat_conectada().getId())
			{
				for(DEMANDA_ACT dem : Conexions.demanda_acts)
				{
					if(dem.getId_equip() == e.getId())
					{
						for(ACTIVITATS act : Conexions.activitats)
						{
							if(act.getId_demanda_act() == dem.getId())
							{
								activitats.add(act);
							}
						}
					}
				}
			}
		}
		final ActivitatsFragment.Adapter adapter = new ActivitatsFragment.Adapter(activitats);

		Activity act = getActivity();
		listaActs.setLayoutManager(new GridLayoutManager(act,1));
		listaActs.addItemDecoration(
				new DividerItemDecoration(act, DividerItemDecoration.VERTICAL));

		listaActs.setItemAnimator(new DefaultItemAnimator());
		listaActs.setAdapter(adapter);

		adapter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				FragmentManager fragmentManager = getFragmentManager ();

				Fragment frag = new ActivitatFragment();
				//-----------extras
				Bundle bundle = new Bundle();
				ACTIVITATS activity = activitats.get(listaActs.getChildAdapterPosition(v));
				bundle.putSerializable("ACT", activity);
				frag.setArguments(bundle);
				//--------------------
				FragmentTransaction ft = fragmentManager.beginTransaction();
				ft.replace(R.id.fragment_content, frag);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();
			}
		});
	}

	public interface ActivitatsListener {
		void onActivitatsSeleccionado(ACTIVITATS a);
	}

	public void setActivitatsListener(ActivitatsFragment.ActivitatsListener listener) {
		this.listener=listener;
	}


	public class Adapter extends RecyclerView.Adapter<ActivitatsFragment.Adapter.PlaceViewHolder>
			implements View.OnClickListener
	{
		public class PlaceViewHolder extends  RecyclerView.ViewHolder
		{
			private TextView nom;
			private TextView equip;
			private TextView horaI;
			private TextView horaF;
			private ListView dies;
			private ArrayList<String> days = new ArrayList<>();

			public PlaceViewHolder(View itemView) {
				super(itemView);

				nom = (TextView)itemView.findViewById(R.id.textNomAct);
				equip = (TextView)itemView.findViewById(R.id.textNomEquipAct);
				horaI = (TextView)itemView.findViewById(R.id.txtHoraIniAct);
				horaF = (TextView)itemView.findViewById(R.id.txtHoraFiAct);
				dies = (ListView)itemView.findViewById(R.id.lstDiesAct);
			}

			public void bindTitular(ACTIVITATS a) {
				String NomEquip = "";
				String HoraInici = "";
				String HoraFinal = "";
				DEMANDA_ACT d = new DEMANDA_ACT();
				for(DEMANDA_ACT dem : Conexions.demanda_acts)
				{
					if(dem.getId() == a.getId_demanda_act())
					{
						d = dem;
					}
				}

				for(int i = 0; i < Conexions.equips.size(); i++)
				{
					if(Conexions.equips.get(i).getId() == d.getId_equip())
					{
						NomEquip = Conexions.equips.get(i).getNom();
					}
				}
				for(int i = 0; i < Conexions.hores.size(); i++)
				{
					if(Conexions.hores.get(i).getId() == d.getId_interval_hores())
					{
						HoraInici = Conexions.hores.get(i).getInici();
						HoraFinal = Conexions.hores.get(i).getFi();
					}
				}
				for(DIA_SEMANA dia : d.getDia_semanas())
				{
					days.add(dia.getNom());
				}
				nom.setText(d.getNom());
				equip.setText(NomEquip);
				horaI.setText(HoraInici);
				horaF.setText(HoraFinal);
				ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, days);

				dies.setAdapter(arrayAdapter);
			}
		}

		private ArrayList<ACTIVITATS> activitats;

		public Adapter(ArrayList<ACTIVITATS> activitats)
		{
			this.activitats = activitats;
		}

		private View.OnClickListener listener;

		public ActivitatsFragment.Adapter.PlaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
			View itemView = LayoutInflater.from(viewGroup.getContext())
					.inflate(R.layout.item_activitats, viewGroup, false);

			itemView.setOnClickListener(this);
			ActivitatsFragment.Adapter.PlaceViewHolder tvh = new ActivitatsFragment.Adapter.PlaceViewHolder(itemView);

			return tvh;
		}

		public void setOnClickListener(View.OnClickListener listener)
		{
			this.listener = listener;
		}
		@Override
		public void onClick(View view)
		{
			if(listener != null)
			{
				listener.onClick(view);
			}
		}

		public int getItemCount() {
			return activitats.size();
		}


		public void onBindViewHolder(ActivitatsFragment.Adapter.PlaceViewHolder viewHolder, int pos) {
			ACTIVITATS item = activitats.get(pos);

			viewHolder.bindTitular(item);
		}
	}
}
