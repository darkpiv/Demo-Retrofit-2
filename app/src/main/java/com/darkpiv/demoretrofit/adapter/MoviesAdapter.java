package com.darkpiv.demoretrofit.adapter;

/**
 * Created by darkpiv-PC on 6/6/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.darkpiv.demoretrofit.R;
import com.darkpiv.demoretrofit.activity.NextActivity;
import com.darkpiv.demoretrofit.model.Movie;

import org.json.JSONArray;

import java.util.ArrayList;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    public Context mContext;
    public ArrayList<Movie> data;
    public LayoutInflater inf;

    public MoviesAdapter(Context context, JSONArray data) {
        this(context, Movie.getMovieData(data));
    }


    public MoviesAdapter(Context context, ArrayList<Movie> data) {
        this.mContext = context;
        this.data = data;
        inf = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = inf.inflate(R.layout.activity_movie, null);
        MovieViewHolder cell = new MovieViewHolder(view);

        return cell;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        final Movie cell = this.data.get(position);
        holder.movieTitle.setText(cell.title);
        holder.data.setText(cell.releaseDate);

        holder.movieDescription.setText(cell.overview);
        holder.rating.setText(cell.voteAverage.toString());
        holder.moviesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NextActivity.class);
                final Intent tittle = intent.putExtra("Tittle", cell.title);
                final Intent overview = intent.putExtra("Overview",cell.overview);
                final Intent releaseDate = intent.putExtra("Release Date",cell.releaseDate);
                final Intent rating = intent.putExtra("Rating",cell.voteAverage);
                v.getContext().startActivity(intent);


                Toast.makeText(v.getContext(),cell.title.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(JSONArray array) {
        ArrayList<Movie> data = Movie.getMovieData(array);
        setData(data);
    }

    public void setData(ArrayList<Movie> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    public static class MovieViewHolder extends RecyclerView.ViewHolder  {
        public TextView movieTitle;
        public  LinearLayout moviesLayout;

        public TextView data;
        public TextView movieDescription;
        public TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movie_layout);
            movieTitle = (TextView) v.findViewById(R.id.tv_title);
            data = (TextView) v.findViewById(R.id.tv_subtitle);
            movieDescription = (TextView) v.findViewById(R.id.tv_description);
            rating = (TextView) v.findViewById(R.id.tv_rating);


        }



    }


}