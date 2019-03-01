package com.example.u93.leagueapp.presenters;

import com.example.u93.leagueapp.models.EventObject;
import com.example.u93.leagueapp.models.Team;
import com.example.u93.leagueapp.models.TeamObject;
import com.example.u93.leagueapp.services.Repository;
import com.example.u93.leagueapp.views.interfaces.ITeamView;

import java.io.IOException;

public class TeamPresenter extends BasePresenter<ITeamView>{

    Repository repository;

    public void getTeamById(String idTeam){
        repository = new Repository();
        try{
            TeamObject getTeam = repository.getTeamById(idTeam);
            EventObject getEvent = repository.getEventsByTeam(idTeam);
            Team team = getTeam.getTeams().get(0);
            team.setEvents(getEvent.getEvents());
            getView().loadTeamInfo(team);
        } catch (IOException e){

        }
    }
}
