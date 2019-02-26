package com.example.u93.leagueapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.models.League;
import com.example.u93.leagueapp.presenters.LeaguePresenter;

import java.util.ArrayList;

public class AdapterLeagues extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<League> leaguesArrayList;
    private Context context;
    LeaguePresenter leaguePresenter;

    public AdapterLeagues(ArrayList<League> leaguesArrayList, Context context, LeaguePresenter presenter) {
        this.leaguesArrayList = leaguesArrayList;
        this.context = context;
        this.leaguePresenter = presenter;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CustomViewHolder customViewHolder = (CustomViewHolder) holder;
        final League liga = leaguesArrayList.get(position);
        customViewHolder.ligaName.setText(liga.getName());
        //customViewHolder.ligaDescription.setText(liga.getDescription());
        ((CustomViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        leaguePresenter.getTeams(liga.getIdLeague());
                    }
                });
                thread.start();
            }
        });

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
        private CardView cardView;
        private TextView ligaName;
        private TextView ligaDescription;

        public CustomViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewItemLeague);
            ligaName = itemView.findViewById(R.id.tvLeague);
        }
    }

}


