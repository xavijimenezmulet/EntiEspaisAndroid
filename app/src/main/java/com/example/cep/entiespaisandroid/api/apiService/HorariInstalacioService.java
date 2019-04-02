package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.HORARI_INSTALACIO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HorariInstalacioService
{
	@GET("api/HORARI_INSTALACIO")
	Call<ArrayList<HORARI_INSTALACIO>> getHorariInstalacio();
}
