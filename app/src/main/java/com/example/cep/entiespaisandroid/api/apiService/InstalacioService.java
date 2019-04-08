package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.INSTALACIONS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InstalacioService
{
	@GET("api/INSTALACIONS")
	Call<ArrayList<INSTALACIONS>> getInstalacions();

}
