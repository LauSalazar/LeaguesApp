package com.example.u93.leagueapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class League implements Serializable {

    @SerializedName("idLeague")
    @Expose
    private String idLeague;

    @SerializedName("strLeague")
    @Expose
    private String name;

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
