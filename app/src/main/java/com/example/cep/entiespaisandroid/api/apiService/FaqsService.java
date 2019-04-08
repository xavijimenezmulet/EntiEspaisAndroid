package com.example.cep.entiespaisandroid.api.apiService;

import com.example.cep.entiespaisandroid.classes.FAQS;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FaqsService
{
	@GET("api/FAQS")
	Call<ArrayList<FAQS>> getFaqs();
}
