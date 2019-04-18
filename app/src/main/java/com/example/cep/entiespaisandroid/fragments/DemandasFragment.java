package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.activities.MainActivity;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;
import java.util.List;

public class DemandasFragment extends Fragment
{
	private RecyclerView listaDem;
	private DemandasFragment.DemandesListener listener;
	private ImageView ImgPrincipal;
	private Button btnDem;
	private Fragment fragment;
	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_demandes, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state)
	{
		super.onActivityCreated(state);

		ImgPrincipal = (ImageView) getView().findViewById(R.id.ImgPrincipalDem);
		ImgPrincipal.setImageResource(R.drawable.logoprincipal);

		btnDem = (Button) getView().findViewById(R.id.btnDem);

		btnDem.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				FragmentManager fragmentManager = getFragmentManager ();

				Fragment frag = new VerDemandaFragment();

				FragmentTransaction ft = fragmentManager.beginTransaction();
				ft.replace(R.id.fragment_content, frag);
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();
			}
		});

		listaDem = (RecyclerView) getView().findViewById(R.id.lstDem);
/*
		listaDem.setAdapter(new DemandasFragment.AdaptadorDemandes(this));

		listaDem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
				if (listener!=null) {
					listener.onEnvironmentSeleccionado(
							(DEMANDA_ACT) listaDem.getAdapter().getItem(pos));
				}
			}
		});
*/
		//---------------------
		final ArrayList<DEMANDA_ACT> demandas = new ArrayList<>();

		for(EQUIPS e : Conexions.equips)
		{
			if(e.getId_entitat() == Conexions.getEntitat_conectada().getId())
			{
				for(DEMANDA_ACT dem : Conexions.demanda_acts)
				{
					if(dem.getId_equip() == e.getId())
					{
						demandas.add(dem);
					}
				}
			}
		}

		final Adapter adapter = new Adapter(demandas);

		Activity act = getActivity();
		listaDem.setLayoutManager(new GridLayoutManager(act,1));
		listaDem.addItemDecoration(
				new DividerItemDecoration(act, DividerItemDecoration.VERTICAL));

		listaDem.setItemAnimator(new DefaultItemAnimator());
		listaDem.setAdapter(adapter);

		adapter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				FragmentManager fragmentManager = getFragmentManager ();

				Fragment frag = new VerDemandaFragment();
				//-----------extras
				Bundle bundle = new Bundle();
				DEMANDA_ACT demanda = demandas.get(listaDem.getChildAdapterPosition(v));
				bundle.putSerializable("DEM", demanda);
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
	public interface DemandesListener {
		void onDemandesSeleccionado(DEMANDA_ACT d);
	}

	public void setDemandesListener(DemandasFragment.DemandesListener listener) {
		this.listener=listener;
	}


	public class Adapter extends RecyclerView.Adapter<Adapter.PlaceViewHolder>
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

				nom = (TextView)itemView.findViewById(R.id.textNomDem);
				equip = (TextView)itemView.findViewById(R.id.textNomEquip);
				horaI = (TextView)itemView.findViewById(R.id.txtHoraIni);
				horaF = (TextView)itemView.findViewById(R.id.txtHoraFi);
				dies = (ListView)itemView.findViewById(R.id.lstDies);
			}

			public void bindTitular(DEMANDA_ACT d) {
				String NomEquip = "";
				String HoraInici = "";
				String HoraFinal = "";

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

		private ArrayList<DEMANDA_ACT> demandas;

		public Adapter(ArrayList<DEMANDA_ACT> demandas)
		{
			this.demandas = demandas;
		}

		private View.OnClickListener listener;

		public PlaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
			View itemView = LayoutInflater.from(viewGroup.getContext())
					.inflate(R.layout.item_demandes, viewGroup, false);

			itemView.setOnClickListener(this);
			PlaceViewHolder tvh = new PlaceViewHolder(itemView);

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
			return demandas.size();
		}


		public void onBindViewHolder(PlaceViewHolder viewHolder, int pos) {
			DEMANDA_ACT item = demandas.get(pos);

			viewHolder.bindTitular(item);
		}
	}


	/*class AdaptadorDemandes extends ArrayAdapter<DEMANDA_ACT>
	{

		Activity context;

		AdaptadorDemandes(Fragment context) {
			super(context.getActivity(), R.layout.item_demandes);
			this.context = context.getActivity();
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.item_demandes, null);

			TextView Nom = (TextView)item.findViewById(R.id.nomDemanda);
			Nom.setText(Conexions.demanda_acts.get(position).getNom());
			TextView NomEquip = (TextView)item.findViewById(R.id.textNomEquip);
			int idEquip = Conexions.demanda_acts.get(position).getId_equip();
			int pos = -1;
			for(int i = 0; i < Conexions.equips.size(); i++)
			{
				if(Conexions.equips.get(i).getId() == idEquip)
				{
					pos = i;
				}
			}
			NomEquip.setText(Conexions.equips.get(pos).getNom());
			int idInterval = Conexions.demanda_acts.get(position).getId_interval_hores();

			for(int i = 0; i < Conexions.hores.size(); i++)
			{
				if(Conexions.hores.get(i).getId() == idInterval)
				{
					pos = i;
				}
			}

			TextView horaInici = (TextView)item.findViewById(R.id.txtHoraIni);
			horaInici.setText(Conexions.hores.get(pos).getInici().toString());
			TextView horaFi = (TextView)item.findViewById(R.id.txtHoraFi);
			horaFi.setText(Conexions.hores.get(pos).getFi().toString());

			ListView listaDies = (ListView) item.findViewById(R.id.lstDies);
			ArrayList<String> dies = new ArrayList<>();
			int idDem = Conexions.demanda_acts.get(position).getId();
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
			listaDies.setAdapter(adapter);

			return(item);
		}
	}*/
}