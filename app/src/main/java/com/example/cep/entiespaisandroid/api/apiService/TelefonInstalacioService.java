package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.HORARI_INSTALACIO;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;
import com.example.cep.entiespaisandroid.classes.TELEFONS_INSTALACIONS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TelefonInstalacioService
{
	@GET("api/TELEFONS_INSTALACIONS/5")
	Call<TELEFONS_INSTALACIONS> getTelefonInstalacio();
}
