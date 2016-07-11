package com.darkpiv.demoretrofit.presenter;

/**
 * Created by darkpiv-PC on 6/9/2016.
 */
public interface FetchDataInterface {
    void fetchPopular(FetchDataCallback callback);
    void fetchTopRated(FetchDataCallback callback);
}
