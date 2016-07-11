package com.darkpiv.demoretrofit.model.rest;

/**
 * Created by darkpiv-PC on 6/6/2016.
 */

import com.darkpiv.demoretrofit.presenter.FetchDataInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.darkpiv.demoretrofit.presenter.FetchDataInterface;
import com.darkpiv.demoretrofit.presenter.FetchDataCallback;
import retrofit2.converter.gson.GsonConverterFactory;
import com.darkpiv.demoretrofit.model.Movie;
import com.darkpiv.demoretrofit.R;

public class ApiClient implements FetchDataInterface {

    public static ApiClient instance;
    public static ApiClient getInstance(){
        if (instance == null){
            return new ApiClient();
        }
        else return instance;
    }

    private Retrofit retrofit;
    private ApiInterface apiInterface;
    public ApiClient() {
        retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").build();
        apiInterface = retrofit.create(ApiInterface.class);
    }



    @Override
    public void fetchPopular(final FetchDataCallback callback){
        Call<ResponseBody> ret = apiInterface.popular();
        ret.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    callback.onFetchSuccess(jsonArray);
                } catch (Exception e) {
                    callback.onFetchFault(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onFetchFault(new Exception(t));
            }
        });
    }


    @Override
    public void fetchTopRated(final FetchDataCallback callback){
        Call<ResponseBody> ret = apiInterface.topRated();
        ret.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    callback.onFetchSuccess(jsonArray);
                } catch (Exception e){
                    callback.onFetchFault(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onFetchFault(new Exception(t));
            }
        });
    }

}