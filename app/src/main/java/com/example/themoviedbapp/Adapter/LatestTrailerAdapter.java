package com.example.themoviedbapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themoviedbapp.Model.MoviesModel;
import com.example.themoviedbapp.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class LatestTrailerAdapter extends RecyclerView.Adapter<LatestTrailerAdapter.ViewHolder> {

    Context context;
    List<MoviesModel> moviesModelList;

    public LatestTrailerAdapter(Context context, List<MoviesModel> moviesModelList) {
        this.context = context;
        this.moviesModelList = moviesModelList;
    }

    @NonNull
    @Override
    public LatestTrailerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trailer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatestTrailerAdapter.ViewHolder holder, int position) {

        holder.cardTrailerImage.setOnClickListener(v -> {
            holder.cardTrailerImage.setVisibility(View.GONE);
            holder.youTubeTrailerPlayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = "sfM7_JLk-84";
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });
        });

    }

    @Override
    public int getItemCount() {
        return moviesModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cardTrailerImage;
        CardView trailerCardView;
        YouTubePlayerView youTubeTrailerPlayer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardTrailerImage = itemView.findViewById(R.id.cardTrailerImage);
            trailerCardView = itemView.findViewById(R.id.trailerCardView);
            youTubeTrailerPlayer = itemView.findViewById(R.id.youtube_trailer_player_view);
        }
    }

}
