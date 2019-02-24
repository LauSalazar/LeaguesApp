package com.example.u93.leagueapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LeagueObject {

    @SerializedName("leagues")
    ArrayList<League> leagues;

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(ArrayList<League> leagues) {
        this.leagues = leagues;
    }
}
