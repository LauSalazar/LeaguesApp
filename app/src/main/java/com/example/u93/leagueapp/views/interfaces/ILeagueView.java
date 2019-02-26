package com.example.u93.leagueapp.views.interfaces;

import com.example.u93.leagueapp.models.League;
import com.example.u93.leagueapp.models.LeagueObject;
import com.example.u93.leagueapp.models.Team;
import com.example.u93.leagueapp.models.TeamObject;

import java.util.ArrayList;

public interface ILeagueView extends IBaseView{
    void loadAdapterLeagues(LeagueObject getLeagues);
    void loadAdapterTeams(TeamObject getTeams);
}
