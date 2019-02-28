package com.example.u93.leagueapp.views.activities;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.models.Team;
import com.squareup.picasso.Picasso;

public class TeamInfoActivity extends AppCompatActivity {

    private Team team;
    private ImageView ivShirt;
    private TextView tvName;
    private TextView tvYearFundation;
    private ImageView ivWebSite;
    private ImageView ivFacebook;
    private ImageView ivTwitter;
    private ImageView ivInstagram;
    private ImageView ivYouTube;
    private TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);

        ivShirt = findViewById(R.id.ivShirt);
        tvName = findViewById(R.id.tvNameTeam);
        tvYearFundation = findViewById(R.id.tvYearFundation);
        ivWebSite = findViewById(R.id.ivWebSite);
        ivFacebook = findViewById(R.id.ivFacebook);
        ivTwitter = findViewById(R.id.ivTwitter);
        ivInstagram = findViewById(R.id.ivInstagram);
        ivYouTube = findViewById(R.id.ivYouTube);
        tvDescription = findViewById(R.id.tvDescription);

        team = (Team) getIntent().getSerializableExtra("team");

        loadTeam();
    }

    private void loadTeam() {
        tvName.setText(team.getName());
        Picasso.get().load(team.getSrcShirt()).into(ivShirt);
        tvYearFundation.setText(team.getYearFoundation());
        tvDescription.setText(team.getDescription());


    }
}
