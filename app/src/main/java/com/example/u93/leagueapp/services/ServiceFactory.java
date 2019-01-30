package com.example.u93.leagueapp.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    private static final String API_BASE_PATH = "https://www.thesportsdb.com/api/v1/json/1/";
    //https://www.thesportsdb.com/api/v1/json/1/all_leagues.php
    //https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=4328
    //https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=133604
    private Retrofit retrofit;

    public ServiceFactory(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30,TimeUnit.SECONDS).writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();

        retrofit = new Retrofit.Builder().baseUrl(API_BASE_PATH).client(okHttpClient)
                .addConverterFactory(getGsonConverter()).build();
    }

    private Converter.Factory getGsonConverter(){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return GsonConverterFactory.create(gson);
    }

    public Object getInstanceService(Class service){
        return retrofit.create(service);
    }


}
