package com.example.themoviedbapp.Model;

import com.google.gson.annotations.SerializedName;

public class SliderData {

    @SerializedName("backdrop_path")
    private String backdrop_path;

    public SliderData(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getImgUrl() {
        return backdrop_path;
    }

    public void setImgUrl(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}
