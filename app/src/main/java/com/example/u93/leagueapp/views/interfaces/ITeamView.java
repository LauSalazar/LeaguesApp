package com.example.u93.leagueapp.views.interfaces;

import com.example.u93.leagueapp.models.TeamObject;

public interface ITeamView extends IBaseView {

    void loadAdapterTeams(final TeamObject teamObject);
}
