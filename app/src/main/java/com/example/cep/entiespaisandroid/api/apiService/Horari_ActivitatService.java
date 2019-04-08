package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.HORARI_ACTIVITAT;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Horari_ActivitatService
{
	@GET("api/HORARI_ACTIVITAT")
	Call<ArrayList<HORARI_ACTIVITAT>> getHorari_activitats();

	@GET("api/HORARI_ACTIVITAT/{id}")
	Call<HORARI_ACTIVITAT> getHorariActId(@Path("id")int id);

	@POST("api/HORARI_ACTIVITAT")
	Call<HORARI_ACTIVITAT> InsertHorariAct(@Body HORARI_ACTIVITAT horari_activitat);

	@DELETE("api/HORARI_ACTIVITAT")
	Call<HORARI_ACTIVITAT> DeleteHorariAct(@Body HORARI_ACTIVITAT horari_activitat);

	@PUT("api/HORARI_ACTIVITAT")
	Call<HORARI_ACTIVITAT> UpdateHorariAct(@Body HORARI_ACTIVITAT horari_activitat);
}
