package com.darkpiv.demoretrofit.presenter;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.darkpiv.demoretrofit.activity.MainActivity;
import com.darkpiv.demoretrofit.model.rest.ApiClient;
import com.darkpiv.demoretrofit.screen_contract.MainScreen;

import org.json.JSONArray;


/**
 * Created by darkpiv-PC on 6/8/2016.
 */
public class MainPresenter extends BasePresenter {

    ApiClient apiClient;

    public MainPresenter(Context context) {
        super(context);
        apiClient = ApiClient.getInstance();
    }

    public void fetchData() {
        apiClient.fetchPopular(new FetchDataCallback() {
            @Override
            public void onFetchSuccess(JSONArray data) {
                getParent().mainMoviesAdapter.setData(data);
            }

            @Override
            public void onFetchFault(Exception e) {
                e.printStackTrace();
            }
        });
    }

    private MainActivity getParent() {
        return (MainActivity) this.context;
    }

    public void sayHello() {
        Toast.makeText(context,"hello",Toast.LENGTH_LONG);
    }


    public void OnItemClickHandler(MainScreen mainScreen) {
        mainScreen.launchNextActivity();
    }
}
