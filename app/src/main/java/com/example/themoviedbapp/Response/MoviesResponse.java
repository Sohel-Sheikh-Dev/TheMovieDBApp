package com.example.themoviedbapp.Response;

import com.example.themoviedbapp.Model.MoviesModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {

    @SerializedName("results")
    List<MoviesModel> results;

    public MoviesResponse(List<MoviesModel> results) {
        this.results = results;
    }

    public List<MoviesModel> getResults() {
        return results;
    }

    public void setResults(List<MoviesModel> results) {
        this.results = results;
    }

}
