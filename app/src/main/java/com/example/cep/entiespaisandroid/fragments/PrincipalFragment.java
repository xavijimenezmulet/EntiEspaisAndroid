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
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.example.cep.entiespaisandroid.utilities.Utilitats;

import java.util.concurrent.ConcurrentHashMap;

public class PrincipalFragment extends Fragment
{

	private ListView equipsEntitatPrincipal;
	private EquipsListener listener;
	private ImageView ImgPrincipal;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_principal, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);

		ImgPrincipal = (ImageView)getView().findViewById(R.id.ImgPrincipal);
		ImgPrincipal.setImageResource(R.drawable.logoprincipal);
		equipsEntitatPrincipal = (ListView) getView().findViewById(R.id.equipsEntitatPrincipal);

		equipsEntitatPrincipal.setAdapter(new AdaptadorEquips(this));

		equipsEntitatPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
				if (listener!=null) {
					listener.onEnvironmentSeleccionado(
							(EQUIPS) equipsEntitatPrincipal.getAdapter().getItem(pos));
				}
			}
		});


	}

	public interface EquipsListener {
		void onEnvironmentSeleccionado(EQUIPS e);
	}

	public void setEquipsListener(EquipsListener listener) {
		this.listener=listener;
	}

	class AdaptadorEquips extends ArrayAdapter<EQUIPS>
	{

		Activity context;

		AdaptadorEquips(Fragment context) {
			super(context.getActivity(), R.layout.items_listequips);
			this.context = context.getActivity();
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.items_listequips, null);

			TextView IdTitulo = (TextView)item.findViewById(R.id.TextEquip);
			IdTitulo.setText(Conexions.equips.get(position).getNom());

			return(item);
		}
	}
}



























