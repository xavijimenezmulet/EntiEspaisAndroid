package com.example.cep.entiespaisandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.EQUIPS;

public class ContacteFragment extends Fragment
{
	private TextView TextDescripcio;
	private TextView TextAdresa;
	private TextView TextEmail;
	private TextView TextHorari;
	private TextView TextTelefon;
	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_contacte, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);

		TextDescripcio = (TextView)getView().findViewById(R.id.TextDescripcio);
		TextAdresa = (TextView)getView().findViewById(R.id.TextAdresa);
		TextEmail = (TextView)getView().findViewById(R.id.TextEmail);
		TextHorari = (TextView)getView().findViewById(R.id.TextHorari);
		TextTelefon = (TextView)getView().findViewById(R.id.TextTelefon);
		TextDescripcio.setText("L’Ajuntament de Sant Cugat és la institució local encarregada del govern i l’administració del terme municipal de Sant Cugat del Vallès. El seu principal òrgan de govern és el Ple municipal, presidit per l’alcalde o alcaldessa i format per 25 regidors i regidores.\n" +
				"\n" +
				"En aquest apartat de la web municipal podeu consultar quins són els òrgans de govern i administració de l’Ajuntament de Sant Cugat, com funcionen i qui els forma.\n" +
				"\n" +
				"També trobareu tota la informació dels tràmits i serveis municipals, així com els diferents canals que l’Ajuntament posa a la vostra disposició per poder-hi accedir o estar-ne al corrent, ja sigui de forma presencial o telemàtica.\n" +
				"\n" +
				"La major part dels serveis i oficines municipals es troben a la casa consistorial, a la plaça de la Vila. En la planta baixa d’aquest modern edifici s'ubiquen la Sala de Plens i serveis d'atenció al públic, com l'Oficina d'Atenció Ciutadana (OAC). Les àrees més representatives de l'Ajuntament, com Alcaldia, Secretaria General i Gerència, es troben a la primera planta.");
		TextAdresa.setText("Direcció: Plaça de la Vila, 1, 08172 Sant Cugat del Vallès, Barcelona");
		TextEmail.setText("ajuntamentsc@ajuntamentsc.cat");
		TextHorari.setText("Dilluns\t\t8:00–18:45\n"+
							"Dimarts\t\t8:00–18:45\n" +
							"Dimecres\t\t8:00–18:45\n" +
							"Dijous\t\t8:00–18:45\n" +
							"Divendres\t8:00–14:00\n" +
							"Dissabte\t\tTancat\n" +
							"Diumenge\tTancat\n");
		TextTelefon.setText("Telèfon: 935 65 70 00 - 010");

	}
}
