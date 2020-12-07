package com.example.android2finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder> {

    private ArrayList<Deals> deals;

    public CustomRecyclerViewAdapter(ArrayList<Deals> deals) {
        this.deals = deals;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,null);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Deals deals = this.deals.get(position);
        holder.poster.setImageResource(deals.getPoster());
    }

    @Override
    public int getItemCount() {
        if (deals != null) {
            return deals.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView poster;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.poster = itemView.findViewById(R.id.poster);

        }


    }
}
