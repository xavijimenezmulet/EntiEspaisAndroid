package com.example.cep.entiespaisandroid.api.apiService;
;
import com.example.cep.entiespaisandroid.classes.TELEFONS_ENTITATS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TelefonsEntitatsService
{
	@GET("api/TELEFONS_ENTITATS")
	Call<ArrayList<TELEFONS_ENTITATS>> getTelefonsEntitat();

	@POST("api/TELEFONS_ENTITATS")
	Call<ArrayList<TELEFONS_ENTITATS>> setTelefonEntitat(@Body TELEFONS_ENTITATS telefonEntitat);

	@DELETE("api/ENTITATS/{id}")
	Call<ArrayList<TELEFONS_ENTITATS>> deleteTelefonEntitat(@Path("id") int id);

	@PUT("api/ENTITATS/{id}")
	Call<ArrayList<TELEFONS_ENTITATS>> updateTelefonEntitat(@Path("id") int id, @Body TELEFONS_ENTITATS telefonEntitat );
}
