package com.example.u93.leagueapp.services;

import com.example.u93.leagueapp.models.LeagueObject;
import com.example.u93.leagueapp.models.TeamObject;

import java.io.IOException;

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

    public TeamObject getTeams(String idLeague) throws  IOException{
        Call<TeamObject> call = iServices.getTeamsByLeague(idLeague);
        Response<TeamObject> response = call.execute();
        if (response.errorBody() != null){
            return null;
        } else {
            return response.body();
        }
    }

    public TeamObject getTeamById(String idTeam) throws IOException{
        Call<TeamObject> call = iServices.getTeamById(idTeam);
        Response<TeamObject> response = call.execute();
        if (response.errorBody() != null) {
            return null;
        } else {
            return response.body();
        }
    }
}
