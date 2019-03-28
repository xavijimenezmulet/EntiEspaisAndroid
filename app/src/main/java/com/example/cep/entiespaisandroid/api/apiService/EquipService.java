package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.EQUIPS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EquipService
{
	@GET("api/EQUIPS")
	Call<ArrayList<EQUIPS>> getEquips();

	//..

}
