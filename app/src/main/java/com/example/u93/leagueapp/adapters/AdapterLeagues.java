package com.example.u93.leagueapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.models.League;

import java.util.ArrayList;

public class AdapterLeagues extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<League> leaguesArrayList;
    private Context context;

    public AdapterLeagues(ArrayList<League> leaguesArrayList, Context context) {
        this.leaguesArrayList = leaguesArrayList;
        this.context = context;
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CustomViewHolder customViewHolder = (CustomViewHolder) holder;
        League liga = leaguesArrayList.get(position);
        customViewHolder.ligaName.setText(liga.getName());
        //customViewHolder.ligaDescription.setText(liga.getDescription());

    }
    @Override
    public int getItemCount() {
        return leaguesArrayList.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_leagues,parent,false);
        return new CustomViewHolder(view);
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView ligaName;
        private TextView ligaDescription;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ligaName = itemView.findViewById(R.id.tvLeague);
        }
    }

}


