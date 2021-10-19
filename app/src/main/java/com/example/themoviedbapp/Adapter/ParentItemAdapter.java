package com.example.themoviedbapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themoviedbapp.Items.ParentItem;
import com.example.themoviedbapp.R;

import java.util.List;

public class ParentItemAdapter extends RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder> {

    private final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<ParentItem> itemList;
    Context context;

    public ParentItemAdapter(Context context, List<ParentItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {

        ParentItem parentItem = itemList.get(position);

        holder.parentTV.setText(parentItem.getParentItemTextView());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.childRecyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setInitialPrefetchItemCount(parentItem.getMoviesModelArrayList().size());

        ChildItemAdapter childItemAdapter = new ChildItemAdapter(context.getApplicationContext(), parentItem.getMoviesModelArrayList());
        holder.childRecyclerView.setLayoutManager(linearLayoutManager);
        holder.childRecyclerView.setAdapter(childItemAdapter);
        holder.childRecyclerView.setRecycledViewPool(viewPool);


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ParentViewHolder extends RecyclerView.ViewHolder {

        private final TextView parentTV;
        private final RecyclerView childRecyclerView;
        private final Spinner dropDownMenu;

        ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            parentTV = itemView.findViewById(R.id.parentTextView);
            childRecyclerView = itemView.findViewById(R.id.childRecyclerView);
            dropDownMenu = itemView.findViewById(R.id.dropdown_menu);
        }
    }
}
