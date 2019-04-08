package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.SEXE;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SexeService
{
	@GET("api/SEXEs")
	Call<ArrayList<SEXE>> getSexes();
}
