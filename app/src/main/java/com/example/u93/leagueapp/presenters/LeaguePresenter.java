package com.example.u93.leagueapp.presenters;

import com.example.u93.leagueapp.models.League;
import com.example.u93.leagueapp.services.Repository;
import com.example.u93.leagueapp.views.interfaces.ILeagueView;

import java.io.IOException;
import java.util.ArrayList;

public class LeaguePresenter extends BasePresenter<ILeagueView> {

    Repository repository;

    public void getLeagues(){
        repository = new Repository();
        try {
            ArrayList<League> getLeagues = repository.getLeagues();
            getView().loadAdapterLeagues(getLeagues);

        } catch (IOException e){

        }
    }
}
