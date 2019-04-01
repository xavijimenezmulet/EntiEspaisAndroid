package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.EQUIPS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Body;

public interface EquipService
{
	@GET("api/EQUIPS")
	Call<ArrayList<EQUIPS>> getEquips();

	@POST("api/EQUIPS")
	Call<EQUIPS> insertEquip(@Body EQUIPS equip);
	
	@DELETE("api/EQUIPS/{id}")
	Call<EQUIPS> deleteEquip(@Path("id") int id);
		
 	@PUT(""api/EQUIPS/{id}")
	Call<EQUIPS> modificarEquip(@Path("id") int id, @Body EQUIPS equip);
}
