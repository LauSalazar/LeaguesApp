package com.example.u93.leagueapp.presenters;

import com.example.u93.leagueapp.models.League;
import com.example.u93.leagueapp.services.Repository;
import com.example.u93.leagueapp.views.interfaces.ILeagueView;

import java.util.ArrayList;

public class LeaguePresenter extends BasePresenter<ILeagueView> {

    Repository repository;

    public ArrayList<League> getLeagues(){
        repository = new Repository();
        //repository.getLeagues();
        return null;
    }
}
