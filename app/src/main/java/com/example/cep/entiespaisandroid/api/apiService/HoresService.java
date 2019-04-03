package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.HORES;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HoresService
{
	@GET("api/HORES")
	Call<ArrayList<HORES>> getHores();

	//Obtener hora por id
	@GET("api/HORES/{id}")
	Call<HORES> getHoresById(@Path("id") int id);
}
