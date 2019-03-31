package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.ADMINISTRADORS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AdministradorService
{
	@GET("api/ADMINISTRADORS")
	Call<ArrayList<ADMINISTRADORS>> getAdministradors();

	//..
}
