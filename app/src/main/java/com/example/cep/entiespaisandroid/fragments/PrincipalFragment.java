package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.activities.MainActivity;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.utilities.Conexions;
import com.example.cep.entiespaisandroid.utilities.Utilitats;

import java.util.concurrent.ConcurrentHashMap;

import static com.example.cep.entiespaisandroid.activities.MainActivity.navigationView;

public class PrincipalFragment extends Fragment
{
	private CardView cardPerfil;
	private CardView cardEntitats;
	private CardView cardEquips;
	private CardView cardInstalacions;
	private CardView cardDemandes;
	private CardView cardActivitats;
	private CardView cardFaqs;
	private CardView cardContacte;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_principal, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		cardPerfil = (CardView)getView().findViewById(R.id.cardPerfil);
		cardEntitats = (CardView)getView().findViewById(R.id.cardEntitats);
		cardEquips = (CardView)getView().findViewById(R.id.cardEquips);

		cardInstalacions = (CardView)getView().findViewById(R.id.cardInstalacions);
		cardDemandes = (CardView)getView().findViewById(R.id.cardDemandes);
		cardActivitats = (CardView)getView().findViewById(R.id.cardActivitats);
		cardFaqs = (CardView)getView().findViewById(R.id.cardFaqs);
		cardContacte = (CardView)getView().findViewById(R.id.cardContacte);

		cardPerfil.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Fragment fragment = new PerfilFragment();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();
				navigationView.setCheckedItem(R.id.nav_perfil);

				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Perfil");
			}
		});

		cardEntitats.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Fragment fragment = new EntitatsFragment();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();
				navigationView.setCheckedItem(R.id.nav_entitats);
				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Web OMET");
			}
		});

		cardEquips.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Fragment fragment = new EquipsFragment();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();
				navigationView.setCheckedItem(R.id.nav_equips);

				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Equips");
			}
		});

		cardDemandes.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Fragment fragment = new DemandasFragment();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();
				navigationView.setCheckedItem(R.id.nav_demandes);
				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Demandes");
			}
		});

		cardActivitats.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Fragment fragment = new ActivitatsFragment();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();

				navigationView.getMenu().getItem(0).setChecked(false);
				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Activitats");
			}
		});

		cardFaqs.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Fragment fragment = new FaqsFragment();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();

				navigationView.getMenu().getItem(0).setChecked(false);
				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Faq's");
			}
		});

		cardInstalacions.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Fragment fragment = new InstalacionsFragment();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();

				navigationView.setCheckedItem(R.id.nav_instalacions);
				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Instal·lacions");
			}
		});

		cardContacte.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Fragment fragment = new ContacteFragment();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();

				navigationView.getMenu().getItem(0).setChecked(false);
				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Contacte");
			}
		});

	}

}



























