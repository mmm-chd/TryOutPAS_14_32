package com.intent.tryoutpas_14_32;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    // Set your base URL here
    private static final String BASE_URL = "https://www.thesportsdb.com";

    // Retrofit instance
    private static Retrofit retrofit = null;

    // Get Retrofit instance method
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
