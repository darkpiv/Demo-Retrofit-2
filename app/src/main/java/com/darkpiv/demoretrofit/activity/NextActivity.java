package com.darkpiv.demoretrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.darkpiv.demoretrofit.R;
import com.darkpiv.demoretrofit.presenter.NextPresenter;
import com.darkpiv.demoretrofit.screen_contract.NextScreen;

/**
 * Created by darkpiv-PC on 6/8/2016.
 */
public class NextActivity extends AppCompatActivity implements NextScreen {
    NextPresenter nextPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_next);

    }



}
