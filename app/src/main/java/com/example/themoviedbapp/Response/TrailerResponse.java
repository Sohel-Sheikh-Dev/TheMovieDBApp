package com.example.themoviedbapp.Response;

import com.example.themoviedbapp.Model.MovieTVTrailerModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailerResponse {

    @SerializedName("results")
    public List<MovieTVTrailerModel> movieTVTrailerModelList;

    public TrailerResponse(List<MovieTVTrailerModel> movieTVTrailerModelList) {
        this.movieTVTrailerModelList = movieTVTrailerModelList;
    }

    public List<MovieTVTrailerModel> getMovieTVTrailerModelList() {
        return movieTVTrailerModelList;
    }

    public void setMovieTVTrailerModelList(List<MovieTVTrailerModel> movieTVTrailerModelList) {
        this.movieTVTrailerModelList = movieTVTrailerModelList;
    }
}