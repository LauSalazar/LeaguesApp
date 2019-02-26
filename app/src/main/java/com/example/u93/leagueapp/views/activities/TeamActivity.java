package com.example.u93.leagueapp.views.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.adapters.AdapterTeams;
import com.example.u93.leagueapp.models.TeamObject;
import com.example.u93.leagueapp.presenters.TeamPresenter;
import com.example.u93.leagueapp.views.interfaces.ITeamView;

public class TeamActivity extends BaseActivity<TeamPresenter> implements ITeamView {
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

    public void loadAdapterTeams(final TeamObject teamObject) {
        if (this != null){
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapterTeams = new AdapterTeams(teamObject.getTeams(),TeamActivity.this);
                    LinearLayoutManager linearLayoutManager  = new LinearLayoutManager((getApplicationContext()));
                    recyclerViewTeams.setLayoutManager(linearLayoutManager);
                    recyclerViewTeams.setAdapter(adapterTeams);
                }
            });
        }
    }
}
