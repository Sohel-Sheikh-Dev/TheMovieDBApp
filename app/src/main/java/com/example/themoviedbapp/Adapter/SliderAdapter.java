package com.example.themoviedbapp.Adapter;

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
    String [] moviesModelList;

    public SliderAdapter(Context context, String [] moviesModelList) {
        this.context = context;
        this.moviesModelList = moviesModelList;
    }
//    public SliderAdapter(Context context, List<SliderData> sliderDataList) {
//        this.context = context;
//        this.sliderDataList = sliderDataList;
//    }

//    private int [] images;
//
//    public SliderAdapter(int[] images) {
//        this.images = images;
//    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, null);
        return new SliderAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {

//        final SliderData sliderItem = sliderDataList.get(position);
//
//        Glide.with(viewHolder.itemView)
//                .load(sliderItem.getImgUrl())
//                .fitCenter()
//                .into(viewHolder.imageViewBackground);

//        viewHolder.imageViewBackground.setImageResource(images[position]);

        Glide.with(context).load(moviesModelList[position]).into(viewHolder.imageViewBackground);

    }

    @Override
    public int getCount() {
        return moviesModelList.length;
//        return images.length;
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {

        ImageView imageViewBackground;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.myimage);
        }
    }
}


//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.example.themoviedbapp.Model.SliderData;
//import com.example.themoviedbapp.R;
//import com.smarteist.autoimageslider.SliderViewAdapter;
//
//import java.util.List;
//
//public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {
//    @Override
//    public SliderAdapter.SliderViewHolder onCreateViewHolder(ViewGroup parent) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {
//
//    }
//
//    @Override
//    public void onBindViewHolder(SliderAdapter.SliderViewHolder viewHolder, int position) {
//
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    public class SliderViewHolder extends ViewHolder {
//        public SliderViewHolder(View itemView) {
//            super(itemView);
//        }
//    }


//    Context context;
//    List<SliderData> sliderDataList;
//
//    public SliderAdapter(Context context, List<SliderData> sliderDataList) {
//        this.context = context;
//        this.sliderDataList = sliderDataList;
//    }
//
//    @NonNull
//    @Override
//    public SliderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.image_item, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull SliderAdapter.ViewHolder holder, int position) {
//        Glide.with(context).load(sliderDataList.get(position).getImgUrl()).into(holder.imageView);
//    }
//
//    @Override
//    public int getItemCount() {
//        return sliderDataList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView imageView;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            imageView = itemView.findViewById(R.id.myimage);
//
//        }
//    }
//}
