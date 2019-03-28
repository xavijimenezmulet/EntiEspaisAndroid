package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.ENTITATS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntitatService {

	@GET("api/ENTITATS")
	Call<ArrayList<ENTITATS>> getEntitats();


}
