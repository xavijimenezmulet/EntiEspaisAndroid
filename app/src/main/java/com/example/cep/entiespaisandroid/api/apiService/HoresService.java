package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.HORARI_ACTIVITAT;
import com.example.cep.entiespaisandroid.classes.HORES;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Path;

public interface HoresService
{
	@GET("api/HORES")
	Call<ArrayList<HORES>> getHores();

	@GET("api/HORES/{id}")
	Call<HORES> getHoresId(@Path("id")int id);

	@POST("api/HORES")
	Call<HORES> InsertHores(@Body HORES hores);

	@DELETE("api/HORES")
	Call<HORES> DeleteHores(@Body HORES hores);

	@PUT("api/HORES")
	Call<HORES> UpdateHores(@Body HORES hores);



}
