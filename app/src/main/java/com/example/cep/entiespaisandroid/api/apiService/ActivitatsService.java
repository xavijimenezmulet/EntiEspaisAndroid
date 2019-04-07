package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ActivitatsService
{
	@GET("api/ACTIVITATS")
	Call<ArrayList<ACTIVITATS>> getActivitats();

	@DELETE("api/ACTIVITATS/{id}")
	Call<ACTIVITATS> DeleteActivitat(@Path("id")int id);
}
