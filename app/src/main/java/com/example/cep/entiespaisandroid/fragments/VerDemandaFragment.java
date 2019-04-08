package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.example.cep.entiespaisandroid.activities.SplashActivity;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.Demanda_ActService;
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

public class VerDemandaFragment extends Fragment
{
    private ImageView ImgPrincipal;
    private TextView nomDemanda;
    private TextView equipDemanda;
    private TextView horaIniDemanda;
    private TextView horaFiDemanda;
    private TextView instalDemanda;
    private TextView espaiDemanda;
    private ListView lstDias;
    private Button btnDeleteDemanda;
    private ArrayList<DIA_SEMANA> days;
    private DEMANDA_ACT demanda = new DEMANDA_ACT();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_verdemanda, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state)
    {
        super.onActivityCreated(state);

        Bundle bundle = getArguments();
        demanda= (DEMANDA_ACT) bundle.getSerializable("DEM");

        nomDemanda = (TextView) getView().findViewById(R.id.nomDemanda);
        equipDemanda = (TextView) getView().findViewById(R.id.equipDemanda);
        horaIniDemanda = (TextView) getView().findViewById(R.id.horaIniDemanda);
        horaFiDemanda = (TextView) getView().findViewById(R.id.horaFiDemanda);
        instalDemanda = (TextView) getView().findViewById(R.id.instalDemanda);
        espaiDemanda = (TextView) getView().findViewById(R.id.espaiDemanda);
        lstDias = (ListView) getView().findViewById(R.id.lstDias);
        btnDeleteDemanda = (Button) getView().findViewById(R.id.btnDeleteDemanda);

        btnDeleteDemanda.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //--delete-----------------
                Demanda_ActService ds = Api.getApi().create(Demanda_ActService.class);

                Call<DEMANDA_ACT> Dem = ds.DeleteDemandaAct(demanda.getId());

                Dem.enqueue(new Callback<DEMANDA_ACT>()
                {
                    @Override
                    public void onResponse(Call<DEMANDA_ACT> call, Response<DEMANDA_ACT> response)
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
                    public void onFailure(Call<DEMANDA_ACT> call, Throwable t)
                    {
                        Toast.makeText(getActivity(), "HA IDO MAL", Toast.LENGTH_LONG).show();
                    }
                });
                //----------------------

                FragmentManager fragmentManager = getFragmentManager ();

                Fragment frag = new DemandasFragment();

                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_content, frag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        nomDemanda.setText(demanda.getNom());

        EQUIPS e = new EQUIPS();
        for(int i = 0; i < Conexions.equips.size(); i++)
        {
            if(Conexions.equips.get(i).getId() == demanda.getId_equip())
            {
                e = Conexions.equips.get(i);
            }
        }
        equipDemanda.setText(e.getNom());

        HORES hora = new HORES();
        for(int i = 0; i < Conexions.hores.size(); i++)
        {
            if(Conexions.hores.get(i).getId() == demanda.getId_interval_hores())
            {
                hora = Conexions.hores.get(i);
            }
        }
        horaIniDemanda.setText(hora.getInici());
        horaFiDemanda.setText(hora.getFi());

        ESPAIS esp = new ESPAIS();
        for(int i = 0; i < Conexions.espais.size(); i++)
        {
            if(Conexions.espais.get(i).getId() == demanda.getId_espai())
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
        instalDemanda.setText(inst.getNom());
        espaiDemanda.setText(esp.getNom());


        Demanda_ActService ds = Api.getApi().create(Demanda_ActService.class);

        Call<ArrayList<DIA_SEMANA>> diaDem = ds.getDemanda_actDays(demanda.getId());

        diaDem.enqueue(new Callback<ArrayList<DIA_SEMANA>>()
        {
            @Override
            public void onResponse(Call<ArrayList<DIA_SEMANA>> call, Response<ArrayList<DIA_SEMANA>> response)
            {
                switch (response.code())
                {
                    case 200:
                        days = response.body();
                        //Toast.makeText(SplashActivity.this, "Ha ido bien", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DIA_SEMANA>> call, Throwable t)
            {
                Toast.makeText(getActivity(), "HA IDO MAL", Toast.LENGTH_LONG).show();
            }
        });


        ArrayList<String> dias = new ArrayList<>();
        if(days != null) {
            for (DIA_SEMANA dia : days) {
                dias.add(dia.getNom());
            }
        }
/*
        for(int i = 0; i < Conexions.dias_demanda.size(); i++)
        {
            if(Conexions.dias_demanda.get(i).getId_demanda_act() == demanda.getId())
            {
                for(int j = 0; j < Conexions.dies_setmana.size(); i++)
                {
                    if(Conexions.dies_setmana.get(j).getId() == Conexions.dias_demanda.get(i).getId_dia_setmana())
                    {
                        dias.add(Conexions.dies_setmana.get(j).getNom());
                    }
                }
            }
        }
*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,dias);
        lstDias.setAdapter(adapter);

    }
}
