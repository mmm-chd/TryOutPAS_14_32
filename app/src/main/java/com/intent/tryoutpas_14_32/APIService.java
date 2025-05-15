package com.intent.tryoutpas_14_32;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getModelClasses();

    @GET("/api/v1/json/3/search_all_teams.php?s=Soccer&c=Spain")
    Call<TeamResponse> getModelClassesSpain();

}
