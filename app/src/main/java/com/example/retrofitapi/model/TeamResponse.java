package com.example.retrofitapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamResponse {
    @SerializedName("teams")
    private List<com.example.retrofitapi.model.Team> teams;

    public List<com.example.retrofitapi.model.Team> getTeams() {
        return teams;
    }
}