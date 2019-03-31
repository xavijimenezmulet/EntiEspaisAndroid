package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.HORARI_ACTIVITAT;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Horari_ActivitatService
{
	@GET("api/HORARI_ACTIVITAT")
	Call<ArrayList<HORARI_ACTIVITAT>> getHorari_activitats();
}
