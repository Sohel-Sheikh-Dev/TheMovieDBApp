package com.example.themoviedbapp.Details;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themoviedbapp.Adapter.ChildItemAdapter;
import com.example.themoviedbapp.Adapter.ParentItemMediaAdapter;
import com.example.themoviedbapp.Items.ParentMediaItem;
import com.example.themoviedbapp.Model.MovieTVTrailerModel;
import com.example.themoviedbapp.Model.MoviesModel;
import com.example.themoviedbapp.R;
import com.example.themoviedbapp.Response.TrailerResponse;
import com.example.themoviedbapp.Retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetails extends AppCompatActivity {

    TextView textviewReleaseDate, tvReleaseRuntime, tvReleaseVoteAverage;
    List<MovieTVTrailerModel> movieTVTrailerModelList;
    RecyclerView mediaRecyclerView;
    LinearLayoutManager linearLayoutManager;
    private ParentItemMediaAdapter mediaAdapter;
    public List<ParentMediaItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        init();
        getMovieDetails();

    }

    public void getMovieDetails() {
        int i = ChildItemAdapter.mid;
        Toast.makeText(getApplicationContext(), "" + i, Toast.LENGTH_SHORT).show();


        itemList = new ArrayList<>();

        ParentMediaItem itemTop = new ParentMediaItem("getted", movieTVTrailerModelList);
        getMovieTrailer(i);
        itemList.add(itemTop);


        ParentMediaItem itemTop1 = new ParentMediaItem("getted 22", movieTVTrailerModelList);
        getMovieTrailer(i);
        itemList.add(itemTop1);


        mediaAdapter = new ParentItemMediaAdapter(getApplicationContext(), itemList);
        mediaRecyclerView.setAdapter(mediaAdapter);
    }

    public void init() {
        textviewReleaseDate = findViewById(R.id.textViewReleaseDate);
        tvReleaseRuntime = findViewById(R.id.textViewRuntime);
        tvReleaseVoteAverage = findViewById(R.id.textViewVoteAverage);

        movieTVTrailerModelList = new ArrayList<>();

        mediaRecyclerView = findViewById(R.id.mediaRecyclerView);
        linearLayoutManager = new LinearLayoutManager(MovieDetails.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mediaRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void getMovieTrailer(int id) {

        Call<TrailerResponse> data = RetrofitInstance.getRetrofitInstance().getMoviesTrailer(id);
        data.enqueue(new Callback<TrailerResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<TrailerResponse> call, @NonNull Response<TrailerResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    movieTVTrailerModelList.addAll(response.body().getMovieTVTrailerModelList());
                    mediaAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(@NonNull Call<TrailerResponse> call, @NonNull Throwable t) {

            }
        });

    }

    public void getMovieDetails(int id) {

        Call<MoviesModel> data = RetrofitInstance.getRetrofitInstance().getMovieDetails(id);
        data.enqueue(new Callback<MoviesModel>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(@NonNull Call<MoviesModel> call, @NonNull Response<MoviesModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String a = response.body().getRelease_date();
                    int b = response.body().getRuntime();
                    float c = response.body().getVote_average();
                    int h = b / 60;
                    int m = b % 60;

                    /*
                    To get only Year like 2021,2021
                    a = a.substring(0, 4);
                    a.trim();
                    */
                    textviewReleaseDate.setText(a);
                    Log.d("tag", "onResponse: " + textviewReleaseDate.toString());
                    tvReleaseRuntime.setText(String.format("%d hr %d mins", h, m));
                    tvReleaseVoteAverage.setText(String.valueOf(c));
                }

            }

            @Override
            public void onFailure(@NonNull Call<MoviesModel> call, @NonNull Throwable t) {
            }
        });

    }

}