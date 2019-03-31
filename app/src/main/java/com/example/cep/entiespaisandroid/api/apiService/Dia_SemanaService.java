package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dia_SemanaService
{
	@GET("api/DIA_SEMANA")
	Call<ArrayList<DIA_SEMANA>> getDias_demanda();
}
