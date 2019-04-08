package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.HORARI_INSTALACIO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HorariInstalacioService
{
	//Busqueda de Horario mediante el id de instalación
	@GET("api/HORARI_INSTALACIO/by/{id_ins}")
	Call<ArrayList<HORARI_INSTALACIO>> getHorariInstalacio(@Path("id_ins") int id_ins);
}
