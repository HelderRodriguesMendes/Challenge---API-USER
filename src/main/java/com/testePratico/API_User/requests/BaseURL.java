package com.testePratico.API_User.requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseURL {
    public Retrofit baseURL(){
        return new Retrofit.Builder().baseUrl("https://randomuser.me/api/").
                addConverterFactory(GsonConverterFactory.create()).build();
    }
}
