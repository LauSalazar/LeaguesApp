package com.example.u93.leagueapp.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.models.Team;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterTeams extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Team> teams;
    private Context context;
    private OnTeamListener onTeamListener;

    public AdapterTeams(ArrayList<Team> teams, Context context, OnTeamListener onTeamListener) {
        this.teams = teams;
        this.context = context;
        this.onTeamListener = onTeamListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_teams,parent,false);
        return new AdapterTeams.CustomViewHolder(view, onTeamListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterTeams.CustomViewHolder customViewHolder = (AdapterTeams.CustomViewHolder) holder;
        Team team = teams.get(position);
        customViewHolder.teamName.setText(team.getName());
        customViewHolder.stadiumName.setText(team.getStadiumName());
        Picasso.get().load(team.getBadge()).into(customViewHolder.badgeImage);

    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView teamName;
        private TextView stadiumName;
        private ImageView badgeImage;

        OnTeamListener onTeamListener;

        public CustomViewHolder(View itemView, OnTeamListener onTeamListener) {
            super(itemView);
            teamName = itemView.findViewById(R.id.tvTeamName);
            stadiumName = itemView.findViewById(R.id.tvStadiumName);
            badgeImage = itemView.findViewById(R.id.ivBadge);
            this.onTeamListener = onTeamListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onTeamListener.onTeamClick(teams.get(getAdapterPosition()).getIdTeam());
        }
    }

    public interface OnTeamListener{
        void onTeamClick(String idTeam);
    }
}
