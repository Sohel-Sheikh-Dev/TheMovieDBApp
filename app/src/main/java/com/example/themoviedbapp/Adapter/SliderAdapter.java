package com.example.themoviedbapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.themoviedbapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

    Context context;
    String[] moviesModelList;

    public SliderAdapter(Context context, String[] moviesModelList) {
        this.context = context;
        this.moviesModelList = moviesModelList;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, null);
        return new SliderAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {
        Glide.with(context).load(moviesModelList[position]).into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        return moviesModelList.length;
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {

        ImageView imageViewBackground;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.myimage);
        }
    }
}
