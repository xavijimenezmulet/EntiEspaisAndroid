package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.ENTITATS;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EntitatService
{

	@GET("api/ENTITATS")
	Call<ArrayList<ENTITATS>> getEntitats();

	@POST("api/ENTITATS")
	Call<ENTITATS> setEntitat(@Body ENTITATS entitat);

	@DELETE("api/ENTITATS/{id}")
	Call<ENTITATS> deleteEntitat(@Path("id") int id);

	@PUT("api/ENTITATS/{id}")
	Call<ENTITATS> updateEntitat(@Path("id") int id, @Body ENTITATS entitat );
}
