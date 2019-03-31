package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.HORES;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HoresService
{
	@GET("api/HORES")
	Call<ArrayList<HORES>> getHores();
}
