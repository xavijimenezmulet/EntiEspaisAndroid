package com.example.cep.entiespaisandroid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

	public static final String IP_PC_CLASSE_XAVI = "http://172.16.110.1:53808/";
	public static final String IP_PC_CASA_XAVI   = "";
	public static final String IP_PC_CLASSE_LUIS   = "http://172.16.110.1:53808/";
	public static final String IP_PC_CASA_LUIS   = "";
	public static final String IP_PC_CLASSE_JOEL   = "http://172.16.110.1:53808/";
	public static final String IP_PC_CASA_JOEL   = "http://192.168.1.17:53808/";
	public static final String IP_PC_CLASSE_DAVID   = "";
	public static final String IP_PC_CASA_DAVID   = "";

	private static final String BASE_URL = IP_PC_CASA_JOEL;
	private static Retrofit  retrofit = null;

	public static Retrofit getApi(){

		if(retrofit == null){
			retrofit = new Retrofit.Builder()
					.baseUrl(BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.build();
		}

		return retrofit;
	}

}
