package com.example.themoviedbapp.Adapter;

import com.example.themoviedbapp.Model.MovieTVTrailerModel;

import java.util.ArrayList;
import java.util.List;

public class ParentMediaItem {

    public String ParentItemTextView;

    public List<MovieTVTrailerModel> movieTVTrailerModelList = new ArrayList<>();


    public ParentMediaItem(String parentItemTextView, List<MovieTVTrailerModel> movieTVTrailerModelList) {
        ParentItemTextView = parentItemTextView;
        this.movieTVTrailerModelList = movieTVTrailerModelList;
    }

    public String getParentItemTextView() {
        return ParentItemTextView;
    }

    public void setParentItemTextView(String parentItemTextView) {
        ParentItemTextView = parentItemTextView;
    }

    public List<MovieTVTrailerModel> getMovieTVTrailerModelList() {
        return movieTVTrailerModelList;
    }

    public void setMovieTVTrailerModelList(List<MovieTVTrailerModel> movieTVTrailerModelList) {
        this.movieTVTrailerModelList = movieTVTrailerModelList;
    }
}
