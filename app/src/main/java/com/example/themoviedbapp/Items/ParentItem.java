package com.example.themoviedbapp.Items;

import com.example.themoviedbapp.Model.MoviesModel;

import java.util.List;

public class ParentItem {

    public String ParentItemTextView;

    public List<MoviesModel> moviesModelArrayList;

    public ParentItem(String parentItemTextView, List<MoviesModel> moviesModelArrayList) {
        this.ParentItemTextView = parentItemTextView;
        this.moviesModelArrayList = moviesModelArrayList;
    }

    public String getParentItemTextView() {
        return ParentItemTextView;
    }

    public List<MoviesModel> getMoviesModelArrayList() {
        return moviesModelArrayList;
    }

}
