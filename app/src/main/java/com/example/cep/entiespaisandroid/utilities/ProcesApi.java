package com.example.cep.entiespaisandroid.utilities;

import android.widget.Toast;

import com.example.cep.entiespaisandroid.activities.MainActivity;
import com.example.cep.entiespaisandroid.api.Api;
import com.example.cep.entiespaisandroid.api.apiService.Demanda_ActService;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.MensajeError;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProcesApi extends Thread {
    private DEMANDA_ACT demanda;
    private int modo; //1- Select, 2- Insert, 3- Delete
    public static String missatgeS;
    public static String missatgeI;
    public static String missatgeD;

    public ProcesApi(DEMANDA_ACT demanda, int modo) {
        this.demanda = demanda;
        this.modo = modo;
    }

    public ProcesApi(int modo) {
        this.modo = modo;
    }

    @Override
    public void run() {
        super.run();

        switch (modo)
        {
            case 1: select();
                break;
            case 2: insert(demanda);
                break;
            case 3: deleteD(demanda);
                break;
            default:
                break;
        }
    }

    public void select()
    {
        Demanda_ActService ds = Api.getApi().create(Demanda_ActService.class);

        Call<ArrayList<DEMANDA_ACT>> dem = ds.getDemanda_acts();

        dem.enqueue(new Callback<ArrayList<DEMANDA_ACT>>()
        {
            @Override
            public void onResponse(Call<ArrayList<DEMANDA_ACT>> call, Response<ArrayList<DEMANDA_ACT>> response)
            {
                switch (response.code())
                {
                    case 200:
                        Conexions.demanda_acts.clear();
                        Conexions.demanda_acts = response.body();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DEMANDA_ACT>> call, Throwable t)
            {
                missatgeS = "HA IDO MAL";

            }
        });
    }
    public void insert(DEMANDA_ACT demanda)
    {
        Demanda_ActService demandaService = Api.getApi().create(Demanda_ActService.class);
        Call<DEMANDA_ACT> demandaCall = demandaService.InsertDemanda_act(demanda);

        demandaCall.enqueue(new Callback<DEMANDA_ACT>()
        {
            @Override
            public void onResponse(Call<DEMANDA_ACT> call, Response<DEMANDA_ACT> response)
            {
                switch (response.code())
                {
                    case 201:
                        missatgeI = "DEMANDA REALITZADA CORRECTAMENT";

                        break;
                    case 400:
                        Gson gson = new Gson();
                        MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
                        missatgeI =  mensajeError.getMessage();
                        break;
                }
            }

            @Override
            public void onFailure(Call<DEMANDA_ACT> call, Throwable t)
            {
                missatgeI = t.getCause() + " - " + t.getMessage();
            }
        });
    }
    public static void deleteD(DEMANDA_ACT demanda)
    {
        int id = demanda.getId();
        Demanda_ActService ds = Api.getApi().create(Demanda_ActService.class);

        Call<DEMANDA_ACT> Dem = ds.deleteDemandaAct(id);

        Dem.enqueue(new Callback<DEMANDA_ACT>()
        {
            @Override
            public void onResponse(Call<DEMANDA_ACT> call, Response<DEMANDA_ACT> response)
            {
                switch (response.code())
                {
                    case 200:
                       missatgeD = "Demanda Eliminada";

                        break;
                    case 400:
                        Gson gson = new Gson();
                        MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
                        missatgeD = mensajeError.getMessage();
                        break;
                    case 404:
                        missatgeD = "No s'ha trobat el registre";
                        break;
                }
            }

            @Override
            public void onFailure(Call<DEMANDA_ACT> call, Throwable t)
            {
               missatgeD = t.getCause() + " - " + t.getMessage();
            }
        });
    }
}
