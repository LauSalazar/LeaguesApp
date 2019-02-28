package com.example.u93.leagueapp.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.adapters.AdapterTeams;
import com.example.u93.leagueapp.models.Team;
import com.example.u93.leagueapp.models.TeamObject;
import com.example.u93.leagueapp.presenters.TeamPresenter;
import com.example.u93.leagueapp.views.interfaces.ITeamView;

public class TeamActivity extends BaseActivity<TeamPresenter> implements ITeamView, AdapterTeams.OnTeamListener{
    private AdapterTeams adapterTeams;
    private RecyclerView recyclerViewTeams;
    private TeamObject teamObject;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_teams);
        recyclerViewTeams = findViewById(R.id.rvRecyclerTeams);
        teamObject = (TeamObject) getIntent().getSerializableExtra("teamObject");

        setPresenter(new TeamPresenter());
        getPresenter().inject(this, getValidateInternet());

        loadAdapterTeams(teamObject);
    }

    @Override
    public void loadAdapterTeams(final TeamObject teamObject) {
        adapterTeams = new AdapterTeams(teamObject.getTeams(), TeamActivity.this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerViewTeams.setLayoutManager(linearLayoutManager);
        recyclerViewTeams.setAdapter(adapterTeams);

    }

    @Override
    public void loadTeamInfo(Team team) {
        Intent intent = new Intent(TeamActivity.this,TeamInfoActivity.class);
        intent.putExtra("team",team);
        startActivity(intent);

    }

    @Override
    public void onTeamClick(final String idTeam) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getPresenter().getTeamById(idTeam);
            }
        });
        thread.start();
    }
}
