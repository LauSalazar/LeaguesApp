package com.example.u93.leagueapp.services;

import com.example.u93.leagueapp.models.League;
import com.example.u93.leagueapp.models.Team;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IServices {

    @GET("all_leagues.php")
    Call<ArrayList<League>> getLeagues();

    @GET("lookup_all_teams.php[id]")
    Call<ArrayList<Team>> getTeamsByLeague(@Query("id") String idLeague);

    @GET("lookupteam.php[id]")
    Call<Team> getTeam(@Query("id") String idTeam);
}
