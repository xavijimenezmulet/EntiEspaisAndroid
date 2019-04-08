package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.DIAS_DEMANDA;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.HORES;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Dias_DemandaService
{
	@GET("api/DIAS_DEMANDA")
	Call<ArrayList<DIAS_DEMANDA>> getDias_demanda();

	@GET("api/DIAS_DEMANDA/{id}")
	Call<DIAS_DEMANDA> getDiaDemandaId(@Path("id")int id);

	@POST("api/DIAS_DEMANDA")
	Call<DIAS_DEMANDA> InsertDiaDemanda(@Body DIAS_DEMANDA dias_demanda);

	@DELETE("api/DIAS_DEMANDA")
	Call<DIAS_DEMANDA> DeleteDiaDemanda(@Body DIAS_DEMANDA dias_demanda);

	@PUT("api/DIAS_DEMANDA")
	Call<DIAS_DEMANDA> UpdateDiaDemanda(@Body DIAS_DEMANDA dias_demanda);
}
