package com.example.cep.entiespaisandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.EQUIPS;

public class EquipFragment extends Fragment
{
	private TextView nombre, discapacidad, entidad,
			competicion, categoria_edad, categoria_equip,
			sexo, deporte;
	private ListView lista_actividades;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_equip, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state)
	{
		super.onActivityCreated(state);

		nombre = getView().findViewById(R.id.txtNombreEquipo);
		discapacidad = getView().findViewById(R.id.txtDiscapacidadEquipo);
		entidad = getView().findViewById(R.id.txtEntidadEquipo);
		competicion = getView().findViewById(R.id.txtCompeticionEquipo);
		categoria_edad = getView().findViewById(R.id.txtCategoriaEdatEquipo);
		categoria_equip = getView().findViewById(R.id.txtCategoriaEquipo);
		sexo = getView().findViewById(R.id.txtSexoEquipo);
		deporte = getView().findViewById(R.id.txtDeporteEquipo);

		lista_actividades = getView().findViewById(R.id.listaActividadesEquipo);

		EQUIPS equipo = new EQUIPS();
		Bundle bundle = this.getArguments();
		if (bundle != null) {
			equipo = bundle.getParcelable("parcel_equip");
		}

		nombre.setText(equipo.getNom());
		String discapacidad_b = "No";
		if (equipo.getTe_discapacitat()) {
			discapacidad_b = "Sí";
		}
		discapacidad.setText(discapacidad_b);
		entidad.setText(String.valueOf(entidad));

	}

}
