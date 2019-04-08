package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.EQUIPS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EquipService
{
	@GET("api/EQUIPS")
	Call<ArrayList<EQUIPS>> getEquips();

	@GET("api/EQUIPS/{id_entitat}")
	Call<EQUIPS> getEquipsEntitat(@Path("id_entitat")int id_entitat);
	//..

}
