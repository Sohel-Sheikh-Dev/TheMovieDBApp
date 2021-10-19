package com.example.themoviedbapp.Details;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.themoviedbapp.Adapter.ChildItemAdapter;
import com.example.themoviedbapp.Model.MoviesModel;
import com.example.themoviedbapp.R;
import com.example.themoviedbapp.Retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVDetails extends AppCompatActivity {

    TextView textviewReleaseDate, tvReleaseRuntime, tvReleaseVoteAverage,textviewTVReleaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

     //   init();

        int i = ChildItemAdapter.mid;
        Toast.makeText(getApplicationContext(), "" + i, Toast.LENGTH_SHORT).show();
        getTVDetails(i);

    }
/*
    public void init(){
        textviewReleaseDate = findViewById(R.id.textViewReleaseDate);
        textviewTVReleaseDate = findViewById(R.id.textViewTVReleaseDate);
        tvReleaseRuntime = findViewById(R.id.textViewRuntime);
        tvReleaseVoteAverage = findViewById(R.id.textViewVoteAverage);
    }
*/
    public void getTVDetails(int id) {

        Call<MoviesModel> data = RetrofitInstance.getRetrofitInstance().getTVDetails(id);
        data.enqueue(new Callback<MoviesModel>() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onResponse(@NonNull Call<MoviesModel> call, @NonNull Response<MoviesModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String a = response.body().getAir_date();
                    int b = response.body().getEpisode_run_time();
                    float c = response.body().getVote_average();
                    /*
                    To get only Year like 2021,2021
                    a = a.substring(0, 4);
                    a.trim();
                    */
                    textviewTVReleaseDate.setText(a);
                    tvReleaseRuntime.setText(b + " mins");
                    tvReleaseVoteAverage.setText(String.valueOf(c));
                }

            }

            @Override
            public void onFailure(@NonNull Call<MoviesModel> call, @NonNull Throwable t) {
            }
        });

    }

}