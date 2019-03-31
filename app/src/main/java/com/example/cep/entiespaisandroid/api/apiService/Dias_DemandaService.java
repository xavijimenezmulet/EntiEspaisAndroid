package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.DIAS_DEMANDA;
import com.example.cep.entiespaisandroid.classes.HORES;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dias_DemandaService
{
	@GET("api/DIAS_DEMANDA")
	Call<ArrayList<DIAS_DEMANDA>> getDias_demanda();
}
