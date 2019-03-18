package com.example.cep.entiespaisandroid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.fragments.ContacteFragment;
import com.example.cep.entiespaisandroid.fragments.DemandaFragment;
import com.example.cep.entiespaisandroid.fragments.EntitatsFragment;
import com.example.cep.entiespaisandroid.fragments.EquipsFragment;
import com.example.cep.entiespaisandroid.fragments.FaqsFragment;
import com.example.cep.entiespaisandroid.fragments.InstalacionsFragment;
import com.example.cep.entiespaisandroid.fragments.PerfilFragment;
import com.example.cep.entiespaisandroid.fragments.PrincipalFragment;

import static com.example.cep.entiespaisandroid.activities.LoginActivity.contador;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener
{

	private Fragment fragment;
	private NavigationView navigationView;
	private Toolbar toolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setLogo(R.drawable.icono_logo_mas_grande);

		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				fragment = new DemandaFragment();
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.commit();
				navigationView.setCheckedItem(R.id.nav_demanda);
				toolbar.setTitle("Demanda");

			}
		});

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

		navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		if(contador == 1){
			contador++;
		}

		if(savedInstanceState == null){
			fragment = new PrincipalFragment();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			navigationView.setCheckedItem(R.id.nav_principal);
			toolbar.setTitle("Principal");
		}



	}

	@Override
	public void onBackPressed()
	{
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START))
		{
			drawer.closeDrawer(GravityCompat.START);
		} else
		{
			if(fragment instanceof PrincipalFragment){
				super.onBackPressed();
			}
			else{
				fragment = new PrincipalFragment();
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.commit();
				navigationView.setCheckedItem(R.id.nav_principal);
				toolbar.setTitle("Principal");
			}

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			Intent intent = new Intent(MainActivity.this, HeinesActivity.class);
			startActivity(intent);
		}

		return super.onOptionsItemSelected(item);
	}

	private void displaySelectedScreen(int id){
		Fragment f = null;

		switch(id){
			case R.id.nav_principal:
				f = new PrincipalFragment();
				break;
		}

		if(f!=null){
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, f);
			ft.commit();
		}
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item)
	{
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_principal)
		{
			fragment = new PrincipalFragment();
			Toast.makeText(this, "PRINCIPAL", Toast.LENGTH_LONG).show();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			toolbar.setTitle("Principal");
		}
		else if (id == R.id.nav_perfil)
		{
			fragment = new PerfilFragment();
			Toast.makeText(this, "PERFIL", Toast.LENGTH_LONG).show();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			toolbar.setTitle("Perfil");

		} else if (id == R.id.nav_entitats)
		{
			fragment = new EntitatsFragment();
			Toast.makeText(this, "ENTITATS", Toast.LENGTH_LONG).show();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			toolbar.setTitle("Entitats");
		} else if (id == R.id.nav_equips)
		{
			fragment = new EquipsFragment();
			Toast.makeText(this, "EQUIPS", Toast.LENGTH_LONG).show();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			toolbar.setTitle("Equips");
		} else if (id == R.id.nav_instalacions)
		{
			fragment = new InstalacionsFragment();
			Toast.makeText(this, "INSTALACIONS", Toast.LENGTH_LONG).show();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			toolbar.setTitle("Instal·lacions");
		} else if (id == R.id.nav_demanda)
		{
			fragment = new DemandaFragment();
			Toast.makeText(this, "DEMANDA", Toast.LENGTH_LONG).show();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			toolbar.setTitle("Demanda");
		} else if (id == R.id.nav_faqs)
		{
			fragment = new FaqsFragment();
			Toast.makeText(this, "FAQS", Toast.LENGTH_LONG).show();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			toolbar.setTitle("Faq's");
		}
		else if (id == R.id.nav_contacte)
		{
			fragment = new ContacteFragment();
			Toast.makeText(this, "CONTACTE", Toast.LENGTH_LONG).show();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.fragment_content, fragment);
			ft.commit();
			toolbar.setTitle("Contacte");
		}


		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
