package com.intent.tryoutpas_14_32;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamResponse {
    @SerializedName("teams")
    private List<ModelClass> teams;

    public List<ModelClass> getTeams() {
        return teams;
    }
}
