package com.example.retrofitapi.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    @SerializedName("strKeywords")
    private String strKeywords;
    @SerializedName("strTeamBadge")
    private String strBadge;

    // Getters
    public String getIdTeam() { return idTeam; }
    public String getStrTeam() { return strTeam; }
    public String getStrDescriptionEN() { return strDescriptionEN; }
    public String getStrKeywords() { return strKeywords; }
    public String getStrTeamBadge() {return strBadge;}

}