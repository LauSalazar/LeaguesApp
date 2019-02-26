package com.example.u93.leagueapp.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.adapters.AdapterLeagues;
import com.example.u93.leagueapp.models.LeagueObject;
import com.example.u93.leagueapp.models.TeamObject;
import com.example.u93.leagueapp.presenters.LeaguePresenter;
import com.example.u93.leagueapp.views.interfaces.ILeagueView;

public class LeaguesActivity extends BaseActivity<LeaguePresenter> implements ILeagueView {
    private RecyclerView recyclerViewLeagues;
    private AdapterLeagues adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerViewLeagues = findViewById(R.id.rvRecyclerLeagues);

        setPresenter(new LeaguePresenter());
        getPresenter().inject(this, getValidateInternet());

        getLeagues();
    }

    private void getLeagues() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getPresenter().getLeagues();
            }
        });
        thread.start();

    }

    @Override
    public void loadAdapterLeagues(final LeagueObject leagues) {
        if (this != null) {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new AdapterLeagues(leagues.getLeagues(), LeaguesActivity.this, getPresenter());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerViewLeagues.setLayoutManager(linearLayoutManager);
                    recyclerViewLeagues.setAdapter(adapter);
                }
            });
        }
    }

    @Override
    public void loadAdapterTeams(final TeamObject teamObject) {
        if (this != null){
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(LeaguesActivity.this, TeamActivity.class);
                    intent.putExtra("teamObject", teamObject);
                    startActivity(intent);
                }
            });
        }
    }
}