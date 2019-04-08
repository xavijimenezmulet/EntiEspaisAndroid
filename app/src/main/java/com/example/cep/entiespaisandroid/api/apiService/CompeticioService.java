package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.COMPETICIONS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CompeticioService
{
	@GET("api/COMPETICIONS")
	Call<ArrayList<COMPETICIONS>> getCompeticions();

}
