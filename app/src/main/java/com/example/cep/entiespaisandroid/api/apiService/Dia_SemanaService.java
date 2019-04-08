package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Dia_SemanaService
{
	@GET("api/DIA_SEMANA")
	Call<ArrayList<DIA_SEMANA>> getDiasSemana();

	@GET("api/DIA_SEMANA/{id}")
	Call<DIA_SEMANA> getDiaSemanaId(@Path("id")int id);

	@POST("api/DIA_SEMANA")
	Call<DIA_SEMANA> InsertDiaSemana(@Body DIA_SEMANA dia_semana);

	@DELETE("api/DIA_SEMANA")
	Call<DIA_SEMANA> DeleteDiaSemana(@Body DIA_SEMANA dia_semana);

	@PUT("api/DIA_SEMANA")
	Call<DIA_SEMANA> UpdateDiaSemana(@Body DIA_SEMANA dia_semana);
}
