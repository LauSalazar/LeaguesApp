package com.example.u93.leagueapp.views.interfaces;

import com.example.u93.leagueapp.models.League;

import java.util.ArrayList;

public interface ILeagueView extends IBaseView{
    void loadAdapterLeagues(ArrayList<League> getLeagues);
}
