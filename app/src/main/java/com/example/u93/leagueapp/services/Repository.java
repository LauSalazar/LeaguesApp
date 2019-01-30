package com.example.u93.leagueapp.services;

import com.example.u93.leagueapp.models.League;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class Repository {
    private IServices iServices;

    public Repository(){
        ServiceFactory serviceFactory = new ServiceFactory();
        iServices = (IServices) serviceFactory.getInstanceService(IServices.class);
    }

    public ArrayList<League> getLeagues() throws IOException{
        Call<ArrayList<League>> call = iServices.getLeagues();
        Response<ArrayList<League>> response = call.execute();
        if (response.errorBody() != null){
            return null;
        } else {
            return response.body();
        }
    }

}
