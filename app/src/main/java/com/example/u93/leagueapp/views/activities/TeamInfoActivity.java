package com.example.u93.leagueapp.views.activities;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.u93.leagueapp.R;
import com.example.u93.leagueapp.models.Event;
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
    private ListView lvEvents;
    BaseAdapter adaptadorLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);

        getSupportActionBar().hide();

        ivShirt = findViewById(R.id.ivShirt);
        tvName = findViewById(R.id.tvNameTeam);
        tvYearFundation = findViewById(R.id.tvYearFundation);
        ivWebSite = findViewById(R.id.ivWebSite);
        ivFacebook = findViewById(R.id.ivFacebook);
        ivTwitter = findViewById(R.id.ivTwitter);
        ivInstagram = findViewById(R.id.ivInstagram);
        ivYouTube = findViewById(R.id.ivYouTube);
        tvDescription = findViewById(R.id.tvDescription);
        lvEvents = findViewById(R.id.lvEvents);

        team = (Team) getIntent().getSerializableExtra("team");

        loadTeam();
    }

    private void loadTeam() {
        tvName.setText(team.getName());
        Picasso.get().load(team.getSrcShirt()).into(ivShirt);
        tvYearFundation.setText(team.getYearFoundation());
        tvDescription.setText(team.getDescription());

        adaptadorLista = new BaseAdapter() {

            @Override
            public int getCount() {
                return team.getEvents().size();
            }

            @Override
            public Object getItem(int position) {
                return team.getEvents().get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Event event = (Event) getItem(position);

                convertView = LayoutInflater.from(TeamInfoActivity.this).inflate(R.layout.item_event,null);
                TextView tvEvento = convertView.findViewById(R.id.tvEvent);
                if (event != null){
                    if (event.getStrEvent() != null && event.getStrDate()!= null){
                        tvEvento.setText(event.getStrEvent().concat(" ").concat(event.getStrDate()));
                    } else if (event.getStrEvent() != null){
                        tvEvento.setText(event.getStrEvent());
                    }
                }
                return convertView;
            }
        };
        lvEvents.setAdapter(adaptadorLista);
    }

    private String validarUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        return url;
    }

    public void onClickWebSite(View view) {
        Uri uri = Uri.parse(validarUrl(team.getSrcWebSite()));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickFacebook(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(validarUrl(team.getSrcFacebook())));
        startActivity(i);
    }

    public void onClickTwitter(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(validarUrl(team.getSrcTwitter())));
        startActivity(i);
    }

    public void onClickInstagram(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(validarUrl(team.getSrcInstagram())));
        startActivity(i);
    }

    public void onClickYoutube(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(validarUrl(team.getSrcYoutube())));
        startActivity(i);
    }
}
