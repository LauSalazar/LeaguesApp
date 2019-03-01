package com.example.u93.leagueapp.services;

import com.example.u93.leagueapp.models.EventObject;
import com.example.u93.leagueapp.models.League;
import com.example.u93.leagueapp.models.LeagueObject;
import com.example.u93.leagueapp.models.Team;
import com.example.u93.leagueapp.models.TeamObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IServices {

    @GET("all_leagues.php")
    Call<LeagueObject> getLeagues();

    @GET("lookup_all_teams.php")
    Call<TeamObject> getTeamsByLeague(@Query("id") String idLeague);

    @GET("lookupteam.php")
    Call<TeamObject> getTeamById(@Query("id") String idTeam);

    @GET("eventsnext.php")
    Call<EventObject> getEventsByTeam(@Query("id") String idTeam);

    //https://www.thesportsdb.com/api/v1/json/1/eventsnext.php?id=133602
}
