package com.example.cep.entiespaisandroid.api.apiService;


import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.HORARI_INSTALACIO;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Horari_InstalacioService
{
    @GET("api/HORARI_INSTALACIO")
    Call<ArrayList<HORARI_INSTALACIO>> getHorariInstalacio();
}
