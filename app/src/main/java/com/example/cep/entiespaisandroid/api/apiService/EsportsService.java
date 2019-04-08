package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.ESPORTS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EsportsService
{
	@GET("api/ESPORTS")
	Call<ArrayList<ESPORTS>> getEsports();
}
