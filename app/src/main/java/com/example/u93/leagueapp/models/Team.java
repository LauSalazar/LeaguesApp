package com.example.u93.leagueapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Team implements Serializable {

    @SerializedName("strTeam")
    @Expose
    private String name;

    @SerializedName("idTeam")
    @Expose
    private String idTeam;

    @SerializedName("strStadium")
    @Expose
    private String stadiumName;

    @SerializedName("strTeamBadge")
    @Expose
    private String badge;

    @SerializedName("strTeamJersey")
    @Expose
    private String srcShirt;

    @SerializedName("strDescriptionEN")
    @Expose
    private String description;

    @SerializedName("intFormedYear")
    @Expose
    private String yearFoundation;

    @SerializedName("strWebsite")
    @Expose
    private String srcWebSite;

    @SerializedName("strFacebook")
    @Expose
    private String srcFacebook;

    @SerializedName("strTwitter")
    @Expose
    private String srcTwitter;

    @SerializedName("strInstagram")
    @Expose
    private String srcInstagram;

    @SerializedName("strYoutube")
    @Expose
    private String srcYoutube;

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getSrcShirt() {
        return srcShirt;
    }

    public void setSrcShirt(String srcShirt) {
        this.srcShirt = srcShirt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearFoundation() {
        return yearFoundation;
    }

    public void setYearFoundation(String yearFoundation) {
        this.yearFoundation = yearFoundation;
    }

    public String getSrcWebSite() {
        return srcWebSite;
    }

    public void setSrcWebSite(String srcWebSite) {
        this.srcWebSite = srcWebSite;
    }

    public String getSrcFacebook() {
        return srcFacebook;
    }

    public void setSrcFacebook(String srcFacebook) {
        this.srcFacebook = srcFacebook;
    }

    public String getSrcTwitter() {
        return srcTwitter;
    }

    public void setSrcTwitter(String srcTwitter) {
        this.srcTwitter = srcTwitter;
    }

    public String getSrcInstagram() {
        return srcInstagram;
    }

    public void setSrcInstagram(String srcInstagram) {
        this.srcInstagram = srcInstagram;
    }

    public String getSrcYoutube() {
        return srcYoutube;
    }

    public void setSrcYoutube(String srcYoutube) {
        this.srcYoutube = srcYoutube;
    }
}
