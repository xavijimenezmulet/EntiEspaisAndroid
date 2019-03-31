package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Demanda_ActService
{
	@GET("api/DEMANDA_ACT")
	Call<ArrayList<DEMANDA_ACT>> getDemanda_acts();
}
