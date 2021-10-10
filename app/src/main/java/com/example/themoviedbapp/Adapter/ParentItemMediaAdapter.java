package com.example.themoviedbapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themoviedbapp.Items.ParentMediaItem;
import com.example.themoviedbapp.R;

import java.util.List;

public class ParentItemMediaAdapter extends RecyclerView.Adapter<ParentItemMediaAdapter.ParentViewHolder> {

    private final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<ParentMediaItem> parentMediaItem;
    Context context;

    public ParentItemMediaAdapter(Context context, List<ParentMediaItem> parentMediaItem) {
        this.context = context;
        this.parentMediaItem = parentMediaItem;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        ParentMediaItem parentItem = parentMediaItem.get(position);

        holder.parentTV.setText(parentItem.getParentItemTextView());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.childRecyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setInitialPrefetchItemCount(parentItem.getMovieTVTrailerModelList().size());

        MediaAdapter mediaAdapter = new MediaAdapter(context.getApplicationContext(), parentItem.getMovieTVTrailerModelList());
        holder.childRecyclerView.setLayoutManager(linearLayoutManager);
        holder.childRecyclerView.setAdapter(mediaAdapter);
        holder.childRecyclerView.setRecycledViewPool(viewPool);


    }

    @Override
    public int getItemCount() {
        return parentMediaItem.size();
    }

    static class ParentViewHolder extends RecyclerView.ViewHolder {

        private final TextView parentTV;
        private final RecyclerView childRecyclerView;

        ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            parentTV = itemView.findViewById(R.id.parentTextView);
            childRecyclerView = itemView.findViewById(R.id.childRecyclerView);

        }
    }
}
