package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.utilities.Conexions;

import java.util.ArrayList;

public class EquipsFragment extends Fragment
{
	private ListView llista_equips;
	private Button afegir, editar, eliminar;
	private EquipsListener listener;

	private ArrayList<EQUIPS> equips = new ArrayList<EQUIPS>();

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_equips, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		equips.add(new EQUIPS(1, "F.C. Sant Cugat \nLorem ipsum", false, 1,
				"2018-2019", 15, 3, 2, 1,
				1));
		equips.add(new EQUIPS(3, "F.C. Sant Cugat B \nLorem ipsum", false, 1,
				"2018-2019", 15, 3, 2, 1,
				1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet \nLorem ipsum", false, 1,
				"2018-2019", 15, 3, 2, 1,
				1));

		llista_equips = getView().findViewById(R.id.ListViewEquips);

		int[] colors = {0xFFFFFFFF, 0xFF43A047, 0xFFFFFFFF};
		// https://convertingcolors.com/hex-color-FFFFFF.html
		llista_equips.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
		llista_equips.setDividerHeight(3);

		llista_equips.setAdapter(new AdaptadorEquips(this));
		llista_equips.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
			{
				if (listener != null)
				{
					listener.onEquipSeleccionado((EQUIPS)llista_equips.getAdapter().getItem(i));
				}
			}
		});

		//---------------------------------------------------//
		afegir = getView().findViewById(R.id.btnAfegirEquip);
		afegir.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Toast.makeText(getActivity(), "Añadir", Toast.LENGTH_LONG).show();
			}
		});

		//---------------------------------------------------//
		editar = getView().findViewById(R.id.btnEditarEquip);
		editar.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Toast.makeText(getActivity(), "Editar", Toast.LENGTH_LONG).show();
			}
		});

		//---------------------------------------------------//
		eliminar = getView().findViewById(R.id.btnEliminarEquip);
		eliminar.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Toast.makeText(getActivity(), "Eliminar", Toast.LENGTH_LONG).show();
			}
		});

		//---------------------------------------------------//
	}

	public interface EquipsListener {
		void onEquipSeleccionado(EQUIPS e);
	}

	public void setEquipsListener(EquipsListener listener) {
		this.listener=listener;
	}

	class AdaptadorEquips extends ArrayAdapter<EQUIPS>
	{
		Activity context;

		AdaptadorEquips(Fragment context) {
			super(context.getActivity(), R.layout.items_listequips, /*Conexions.equips*/ equips);
			this.context = context.getActivity();
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.items_listequips, null);

			TextView IdTitulo = (TextView)item.findViewById(R.id.TextEquip);
			IdTitulo.setText(/*Conexions.equips.get(position).getNom()*/equips.get(position).getNom());

			return(item);
		}
	}

}
