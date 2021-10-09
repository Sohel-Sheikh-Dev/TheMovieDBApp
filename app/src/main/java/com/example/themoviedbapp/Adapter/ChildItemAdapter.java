package com.example.themoviedbapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themoviedbapp.Model.MoviesModel;
import com.example.themoviedbapp.Details.MovieDetails;
import com.example.themoviedbapp.R;
import com.example.themoviedbapp.Details.TVDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChildItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    List<MoviesModel> moviesModelArrayList;
    public static int mid;
    final int VIEW_TYPE_ONE = 1;
    final int VIEW_TYPE_TWO = 2;


    public ChildItemAdapter(Context context, List<MoviesModel> moviesModelArrayList) {
        this.context = context;
        this.moviesModelArrayList = moviesModelArrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_ONE) {
            return new ViewHolder1(LayoutInflater.from(context).inflate(R.layout.child_item, parent, false));
        }
        return new ViewHolder2(LayoutInflater.from(context).inflate(R.layout.childtv_item, parent, false));


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.tvTitle.setText(moviesModelArrayList.get(position).getTitle());
//        holder.tvOverview.setText(moviesModelArrayList.get(position).getOverview());
//        holder.tvName.setText(moviesModelArrayList.get(position).getName());
//
//        holder.cardview.setOnClickListener(view -> {
//            Intent intent = new Intent(context, MovieDetails.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            mid = moviesModelArrayList.get(position).getMovie_id();
//            context.startActivity(intent);
//        });


        if (moviesModelArrayList.get(position).getName() == null) {

            ((ViewHolder1) holder).tvTitle.setText(moviesModelArrayList.get(position).getTitle());

            @SuppressLint("SimpleDateFormat") String date_format = parseDate(moviesModelArrayList.get(position).getRelease_date(),
                    new SimpleDateFormat("yyyy-MM-dd"),
                    new SimpleDateFormat("MMM dd,yyyy"));
            ((ViewHolder1) holder).tvDate.setText(date_format);


            float vote = moviesModelArrayList.get(position).getVote_average() * 10;
            int vote_final = Math.round(vote);
            ((ViewHolder1) holder).ratingProgress.setProgress(vote_final);

            Glide.with(context).load(moviesModelArrayList.get(position).getPoster_path()).into(((ViewHolder1) holder).cardImage);

//            ((ViewHolder1) holder).cardImage.setText(moviesModelArrayList.get(position).getOverview());

            ((ViewHolder1) holder).cardview.setOnClickListener(view -> {
                Intent intent = new Intent(context, MovieDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mid = moviesModelArrayList.get(position).getMovie_id();
                context.startActivity(intent);
            });

        }


        if ((moviesModelArrayList.get(position).getTitle() == null)) {
            ((ViewHolder2) holder).TVtvTitle.setText(moviesModelArrayList.get(position).getName());
            ((ViewHolder2) holder).TVtvOverview.setText(moviesModelArrayList.get(position).getOverview());

            ((ViewHolder2) holder).TVcardview.setOnClickListener(view -> {
                Intent intent = new Intent(context, TVDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mid = moviesModelArrayList.get(position).getMovie_id();
                context.startActivity(intent);
            });

        }


    }


    public static String parseDate(String inputDateString, SimpleDateFormat inputDateFormat, SimpleDateFormat outputDateFormat) {
        Date date = null;
        String outputDateString = null;
        try {
            date = inputDateFormat.parse(inputDateString);
            outputDateString = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDateString;
    }


    @Override
    public int getItemCount() {
        return moviesModelArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (moviesModelArrayList.get(position).getName() == null) {
            return VIEW_TYPE_ONE;
        }
        return VIEW_TYPE_TWO;

    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        EditText mainEditText;
        Button searchButton;
        TextView tvTitle, tvDate;
        CardView cardview;
        ImageView cardImage;
        ProgressBar ratingProgress;


        ViewHolder1(final View itemView) {
            super(itemView);

            cardImage = itemView.findViewById(R.id.cardImage);
            ratingProgress = itemView.findViewById(R.id.ratingProgress);

            tvTitle = itemView.findViewById(R.id.title);
            tvDate = itemView.findViewById(R.id.date);
            cardview = itemView.findViewById(R.id.movieOrTvCardView);
            searchButton = itemView.findViewById(R.id.searchButton);
            mainEditText = itemView.findViewById(R.id.search);
        }
    }


    private static class ViewHolder2 extends RecyclerView.ViewHolder {

        EditText mainEditText;
        Button searchButton;
        TextView TVtvTitle, TVtvOverview, TVtvName;
        CardView TVcardview;

        public ViewHolder2(final View itemView) {
            super(itemView);

            TVtvTitle = itemView.findViewById(R.id.TVtitle);
            TVtvOverview = itemView.findViewById(R.id.TVoverview);
            TVtvName = itemView.findViewById(R.id.TVname);
            TVcardview = itemView.findViewById(R.id.TVmovieOrTvCardView);
            searchButton = itemView.findViewById(R.id.searchButton);
            mainEditText = itemView.findViewById(R.id.search);
        }
    }


}
