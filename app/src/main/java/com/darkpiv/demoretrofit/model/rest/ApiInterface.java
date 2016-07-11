package com.darkpiv.demoretrofit.model.rest;
/**
 * Created by darkpiv-PC on 6/6/2016.
 */

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("movie/popular?api_key=6afa07690e0b1a36eadd31f51e90e3a0")
    Call<ResponseBody> popular();

    @GET("movie/top_rated?api_key=6afa07690e0b1a36eadd31f51e90e3a0")
    Call<ResponseBody> topRated();
}



