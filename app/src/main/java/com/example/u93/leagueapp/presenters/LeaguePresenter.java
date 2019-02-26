package com.example.u93.leagueapp.presenters;

import com.example.u93.leagueapp.models.LeagueObject;
import com.example.u93.leagueapp.models.TeamObject;
import com.example.u93.leagueapp.services.Repository;
import com.example.u93.leagueapp.views.interfaces.ILeagueView;

import java.io.IOException;

public class LeaguePresenter extends BasePresenter<ILeagueView> {

    Repository repository;

    public void getLeagues(){
        repository = new Repository();
        try {
            LeagueObject getLeagues = repository.getLeagueObject();
            getView().loadAdapterLeagues(getLeagues);

        } catch (IOException e){

        }
    }

    public void getTeams(String idLeague) {
        repository = new Repository();
        try{
            TeamObject getTeams = repository.getTeams(idLeague);
            getView().loadAdapterTeams(getTeams);
        } catch (IOException e){

        }
    }
}
