package com.example.u93.leagueapp.services;

import com.example.u93.leagueapp.models.League;
import com.example.u93.leagueapp.models.LeagueObject;

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

    public LeagueObject getLeagueObject() throws IOException{
        Call<LeagueObject> call = iServices.getLeagues();
        Response<LeagueObject> response = call.execute();
        if (response.errorBody() != null){
            return null;
        } else {
            return response.body();
        }
    }

}
