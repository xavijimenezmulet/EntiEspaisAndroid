package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Demanda_ActService
{
	@GET("api/DEMANDA_ACT")
	Call<ArrayList<DEMANDA_ACT>> getDemanda_acts();

	@GET("api/DEMANDA_ACT/{id}")
	Call<DEMANDA_ACT> getDemanda_actId(@Path("id")int id);

	@POST("api/DEMANDA_ACT")
	Call<DEMANDA_ACT> InsertDemanda_act(@Body DEMANDA_ACT demanda_act);

	@DELETE("api/DEMANDA_ACT")
	Call<DEMANDA_ACT> DeleteDemandaAct(@Body DEMANDA_ACT demanda_act);

}
