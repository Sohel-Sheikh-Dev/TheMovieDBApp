package com.example.themoviedbapp.Model;

import com.google.gson.annotations.SerializedName;

public class MoviesModel {

    @SerializedName("id")
    public int movie_id;

    public String title,overview,release_date,tagline,backdrop_path,poster_path,name;

    @SerializedName("first_air_date")
    public String air_date;

    public int runtime;

    public int [] episode_run_time;


    public float vote_average;

    public MoviesModel(int movie_id,int [] episode_run_time,String name, String title, String overview, String release_date, String tagline, String backdrop_path, String poster_path, int runtime, float vote_average,String air_date) {
        this.movie_id = movie_id;
        this.title = title;
        this.overview = overview;
        this.name = name;
        this.release_date = release_date;
        this.tagline = tagline;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.runtime = runtime;
        this.vote_average = vote_average;
        this.air_date = air_date;
        this.episode_run_time = episode_run_time;
    }

    public int getEpisode_run_time() {
        return episode_run_time[0];
    }

    public void setEpisode_run_time(int[] episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getBackdrop_path() {
        return "https://image.tmdb.org/t/p/w500/"+backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPoster_path() {
        return "https://image.tmdb.org/t/p/w500/"+poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }
}
