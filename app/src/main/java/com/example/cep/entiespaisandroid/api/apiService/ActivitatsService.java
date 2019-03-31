package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.ACTIVITATS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ActivitatsService
{
	@GET("api/ACTIVITATS")
	Call<ArrayList<ACTIVITATS>> getActivitats();
}
