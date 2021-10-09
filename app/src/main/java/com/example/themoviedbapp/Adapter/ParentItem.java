package com.example.themoviedbapp.Adapter;

import com.example.themoviedbapp.Model.MoviesModel;

import java.util.ArrayList;
import java.util.List;

public class ParentItem {

    public String ParentItemTextView;

    public List<MoviesModel> moviesModelArrayList = new ArrayList<>();

    public ParentItem(String parentItemTextView, List<MoviesModel> moviesModelArrayList) {
        ParentItemTextView = parentItemTextView;
        this.moviesModelArrayList = moviesModelArrayList;
    }

    public String getParentItemTextView() {
        return ParentItemTextView;
    }

    public void setParentItemTextView(String parentItemTextView) {
        ParentItemTextView = parentItemTextView;
    }

    public List<MoviesModel> getMoviesModelArrayList() {
        return moviesModelArrayList;
    }

    public void setMoviesModelArrayList(List<MoviesModel> moviesModelArrayList) {
        this.moviesModelArrayList = moviesModelArrayList;
    }

}
