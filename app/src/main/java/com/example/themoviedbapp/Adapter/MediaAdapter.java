package com.example.themoviedbapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themoviedbapp.Model.MovieTVTrailerModel;
import com.example.themoviedbapp.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder> {

    private final Context context;
    List<MovieTVTrailerModel> movieTVTrailerModelList;

    public MediaAdapter(Context context, List<MovieTVTrailerModel> movieTVTrailerModelList) {
        this.context = context;
        this.movieTVTrailerModelList = movieTVTrailerModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.media_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String keyk = movieTVTrailerModelList.get(position).getKey();
//        holder.name.setText(keyk.toString());
//        Log.d("TAG", "onBindViewHolder: "+keyk);
        holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                                String videoId = "VSB4wGIdDwo";
                youTubePlayer.loadVideo(keyk, 0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieTVTrailerModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

//        TextView name;
        YouTubePlayerView youTubePlayerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
//            name = itemView.findViewById(R.id.name);

        }
    }
}
