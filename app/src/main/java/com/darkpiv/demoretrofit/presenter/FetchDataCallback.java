package com.darkpiv.demoretrofit.presenter;

import org.json.JSONArray;

/**
 * Created by darkpiv-PC on 6/9/2016.
 */
public interface FetchDataCallback {
    void onFetchSuccess(JSONArray data);
    void onFetchFault(Exception e);
}
