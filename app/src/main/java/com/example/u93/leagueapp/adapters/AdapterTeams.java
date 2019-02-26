package com.example.u93.leagueapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.models.Team;

import java.util.ArrayList;

public class AdapterTeams extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Team> teams;
    private Context context;

    public AdapterTeams(ArrayList<Team> teams, Context context) {
        this.teams = teams;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_teams,parent,false);
        return new AdapterTeams.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterTeams.CustomViewHolder customViewHolder = (AdapterTeams.CustomViewHolder) holder;
        Team team = teams.get(position);
        customViewHolder.teamName.setText(team.getName());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView teamName;
        private TextView teamDescription;

        public CustomViewHolder(View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.tvTeamName);
        }
    }
}
