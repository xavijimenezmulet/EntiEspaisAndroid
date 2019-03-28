package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.CATEGORIA_EQUIP;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriaEquipService
{
	@GET("api/CATEGORIA_EQUIP")
	Call<ArrayList<CATEGORIA_EQUIP>> getCategoriasEquips();

	//..

}
