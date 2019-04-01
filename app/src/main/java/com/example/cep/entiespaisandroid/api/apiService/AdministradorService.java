package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.ADMINISTRADORS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Body;

public interface AdministradorService
{
	@GET("api/ADMINISTRADORS")
	Call<ArrayList<ADMINISTRADORS>> getAdministradors();
	
	@POST("api/ADMINISTRADORS")
	Call<ADMINISTRADORS> insertAdministrador(@Body ADMINISTRADORS administrador);
	
	@DELETE("api/ADMINISTRADORS/{id}")
	Call<ADMINISTRADORS> deleteAdministrador(@Path("id") int id);
		
 	@PUT("api/ADMINISTRADORS/{id}")
	Call<ADMINISTRADORS> modificarAdministrador(@Path("id") int id, @Body ADMINISTRADORS administrador);
	
}
