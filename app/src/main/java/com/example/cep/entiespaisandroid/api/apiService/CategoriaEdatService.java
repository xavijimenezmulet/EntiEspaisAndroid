package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.CATEGORIA_EDAT;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriaEdatService
{
	@GET("api/CATEGORIA_EDAT")
	Call<ArrayList<CATEGORIA_EDAT>> getCategoriasEdats();

	//..

}
