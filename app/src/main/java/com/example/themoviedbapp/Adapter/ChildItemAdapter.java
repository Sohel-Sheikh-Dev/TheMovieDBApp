package com.example.themoviedbapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import androidx.core.content.ContextCompat;
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

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (moviesModelArrayList.get(position).getName() == null) {

            ((ViewHolder1) holder).tvTitle.setText(moviesModelArrayList.get(position).getTitle());

            @SuppressLint("SimpleDateFormat") String date_format = parseDate(moviesModelArrayList.get(position).getRelease_date(),
                    new SimpleDateFormat("yyyy-MM-dd"),
                    new SimpleDateFormat("MMM dd, yyyy"));
            ((ViewHolder1) holder).tvDate.setText(date_format);


            float vote = moviesModelArrayList.get(position).getVote_average() * 10;
            int vote_final = Math.round(vote);
            ((ViewHolder1) holder).ratingProgress.setProgress(vote_final);


            String votePercentage = String.valueOf(vote_final);


            if (vote_final == 0 && votePercentage.equals("0")) {
                ((ViewHolder1) holder).ratingPercentage.setText("NR");
                ((ViewHolder1) holder).percentSign.setVisibility(View.GONE);
                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.circle_grey);
                ((ViewHolder1) holder).ratingProgress.setProgressDrawable(drawable);

                int paddingDp = 1;
                float density = context.getResources().getDisplayMetrics().density;
                int paddingPixel = (int) (paddingDp * density);
                ((ViewHolder1) holder).ratingPercentage.setPadding(paddingPixel, 0, 0, 0);

            }
            else {
                ((ViewHolder1) holder).ratingPercentage.setText(votePercentage);
            }



//            if (vote_final < 70) {
//                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.circle_yellow);
//                ((ViewHolder1) holder).ratingProgress.setProgressDrawable(drawable);
//            }


            Glide.with(context).load(moviesModelArrayList.get(position).getPoster_path()).into(((ViewHolder1) holder).cardImage);

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

            ((ViewHolder2) holder).TVCardView.setOnClickListener(view -> {
                Intent intent = new Intent(context, TVDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mid = moviesModelArrayList.get(position).getMovie_id();
                context.startActivity(intent);
            });

        }


    }


    public static String parseDate(String inputDateString, SimpleDateFormat inputDateFormat, SimpleDateFormat outputDateFormat) {
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
        TextView tvTitle, tvDate, ratingPercentage, percentSign;
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
