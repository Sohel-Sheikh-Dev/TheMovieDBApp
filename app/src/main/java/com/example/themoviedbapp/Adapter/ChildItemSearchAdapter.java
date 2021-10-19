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
import com.example.themoviedbapp.Details.MovieDetails;
import com.example.themoviedbapp.Details.TVDetails;
import com.example.themoviedbapp.Model.MoviesModel;
import com.example.themoviedbapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChildItemSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    List<MoviesModel> moviesModelArrayList;
    public static int mid;
    final int VIEW_TYPE_ONE = 1;
    final int VIEW_TYPE_TWO = 2;


    public ChildItemSearchAdapter(Context context, List<MoviesModel> moviesModelArrayList) {
        this.context = context;
        this.moviesModelArrayList = moviesModelArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_ONE) {
            return new ChildItemSearchAdapter.ViewHolder1(LayoutInflater.from(context).inflate(R.layout.child_search_movie_item, parent, false));
        }
        return new ChildItemSearchAdapter.ViewHolder2(LayoutInflater.from(context).inflate(R.layout.childtv_item, parent, false));

    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (moviesModelArrayList.get(position).getName() == null) {

            if (moviesModelArrayList.get(position).getRelease_date() != null) {
                @SuppressLint("SimpleDateFormat") String date_format = parseDate(moviesModelArrayList.get(position).getRelease_date(),
                        new java.text.SimpleDateFormat("yyyy-MM-dd"),
                        new SimpleDateFormat("MMM dd, yyyy"));
                ((ChildItemSearchAdapter.ViewHolder1) holder).tvDate.setText(date_format);

                ((ChildItemSearchAdapter.ViewHolder1) holder).tvTitle.setText(moviesModelArrayList.get(position).getTitle());
                ((ChildItemSearchAdapter.ViewHolder1) holder).tvDescription.setText(moviesModelArrayList.get(position).getOverview());
            }

            if (moviesModelArrayList.get(position).getRelease_date() == null) {
                ((ChildItemSearchAdapter.ViewHolder1) holder).tvDate.setText("");
                ((ViewHolder1) holder).tvOnlyTitleWhileNull.setText(moviesModelArrayList.get(position).getTitle());
                ((ChildItemSearchAdapter.ViewHolder1) holder).tvTitle.setText("");
                ((ChildItemSearchAdapter.ViewHolder1) holder).tvDescription.setText("");
            }

            Glide.with(context).load(moviesModelArrayList.get(position).getPoster_path()).into(((ChildItemSearchAdapter.ViewHolder1) holder).cardImage);
            ((ChildItemSearchAdapter.ViewHolder1) holder).cardview.setOnClickListener(view -> {

                Intent intent = new Intent(context, MovieDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mid = moviesModelArrayList.get(position).getMovie_id();
                context.startActivity(intent);
            });


        }


        if ((moviesModelArrayList.get(position).getTitle() == null)) {
            ((ChildItemSearchAdapter.ViewHolder2) holder).TVtvTitle.setText(moviesModelArrayList.get(position).getName());
            ((ChildItemSearchAdapter.ViewHolder2) holder).TVtvOverview.setText(moviesModelArrayList.get(position).getOverview());

            ((ChildItemSearchAdapter.ViewHolder2) holder).TVCardView.setOnClickListener(view -> {
                Intent intent = new Intent(context, TVDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mid = moviesModelArrayList.get(position).getMovie_id();
                context.startActivity(intent);
            });

        }


    }


    public static String parseDate(String inputDateString, java.text.SimpleDateFormat inputDateFormat, java.text.SimpleDateFormat outputDateFormat) {
        String outputDateString = null;
        try {
            Date date = inputDateFormat.parse(inputDateString);
            assert date != null;
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

    private static class ViewHolder1 extends RecyclerView.ViewHolder {

        EditText mainEditText;
        Button searchButton;
        TextView tvTitle, tvDate, ratingPercentage, percentSign, tvDescription, tvOnlyTitleWhileNull;
        CardView cardview;
        ImageView cardImage;
        ProgressBar ratingProgress;


        ViewHolder1(final View itemView) {
            super(itemView);

            cardImage = itemView.findViewById(R.id.cardImage);
            ratingProgress = itemView.findViewById(R.id.ratingProgress);
            ratingPercentage = itemView.findViewById(R.id.ratingPercentage);
            percentSign = itemView.findViewById(R.id.percentSign);
            tvTitle = itemView.findViewById(R.id.title);
            tvDescription = itemView.findViewById(R.id.description);
            tvDate = itemView.findViewById(R.id.date);
            cardview = itemView.findViewById(R.id.movieOrTvCardViews);
            searchButton = itemView.findViewById(R.id.searchButton);
            mainEditText = itemView.findViewById(R.id.search);
            tvOnlyTitleWhileNull = itemView.findViewById(R.id.onlyTitleWhileNull);
        }
    }

    private static class ViewHolder2 extends RecyclerView.ViewHolder {

        EditText mainEditText;
        Button searchButton;
        TextView TVtvTitle, TVtvOverview, TVtvName;
        CardView TVCardView;

        public ViewHolder2(final View itemView) {
            super(itemView);

            TVtvTitle = itemView.findViewById(R.id.TVtitle);
            TVtvOverview = itemView.findViewById(R.id.TVoverview);
            TVtvName = itemView.findViewById(R.id.TVname);
            TVCardView = itemView.findViewById(R.id.TVmovieOrTvCardView);
            searchButton = itemView.findViewById(R.id.searchButton);
            mainEditText = itemView.findViewById(R.id.search);
        }
    }


}

