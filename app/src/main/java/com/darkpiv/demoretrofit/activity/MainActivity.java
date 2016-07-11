package com.darkpiv.demoretrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.darkpiv.demoretrofit.R;
import com.darkpiv.demoretrofit.adapter.MoviesAdapter;
import com.darkpiv.demoretrofit.model.Movie;
import com.darkpiv.demoretrofit.presenter.MainPresenter;
import com.darkpiv.demoretrofit.screen_contract.MainScreen;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    public MoviesAdapter mainMoviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);
        recyclerView = ((RecyclerView) findViewById(R.id.movies_recycler_view));
        recyclerLayoutManager = new LinearLayoutManager(this);
        mainMoviesAdapter = new MoviesAdapter(this, new ArrayList<Movie>());
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.setAdapter(mainMoviesAdapter);
        mainMoviesAdapter.notifyDataSetChanged();
        mainPresenter.fetchData();


    }



}
