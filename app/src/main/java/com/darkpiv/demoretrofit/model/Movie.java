package com.darkpiv.demoretrofit.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by darkpiv-PC on 6/6/2016.
 */
public class Movie {

    public String overview;
    public String releaseDate;
    public String title;

    public Double voteAverage;



    public Movie(String title, String overview,
                 String releaseDate, Double voteAverage) {

        this.overview = overview;
        this.releaseDate = releaseDate;
        this.title = title;
        this.voteAverage = voteAverage;
    }

    public static Movie getMovie(JSONObject obj) {
        try {
            return new Movie(obj.getString("title"), obj.getString("overview"), obj.getString("release_date"), obj.getDouble("vote_average"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Movie> getMovieData(JSONArray data) {
        ArrayList<Movie> ret = new ArrayList<>();
        try {
            for (int i = 0; i < data.length(); i++) {
                ret.add(Movie.getMovie(data.getJSONObject(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}




