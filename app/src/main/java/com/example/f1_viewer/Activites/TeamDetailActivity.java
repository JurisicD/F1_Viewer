package com.example.f1_viewer.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.f1_viewer.R;

import java.util.List;

public class TeamDetailActivity extends AppCompatActivity {

    TextView tvConstructorId ;
    TextView tvDrivers ;
    TextView tvName ;
    TextView tvNationality ;
    TextView tvPoints ;
    ImageView tvTeamCarImg ;
    ImageView tvTeamLogoImg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        Bundle bundle = getIntent().getExtras();
        int constructorId = bundle.getInt("constructorId", 0);
        List<String> drivers = bundle.getStringArrayList("drivers");
        String name = bundle.getString("name");
        String nationality = bundle.getString("nationality");
        double points = bundle.getDouble("points", 0.0);
        String teamCarImg = bundle.getString("teamCarImg");
        String teamLogoImg = bundle.getString("teamLogoImg");



        tvDrivers = findViewById(R.id.txt_drivers);
         tvName = findViewById(R.id.txt_name);
         tvNationality = findViewById(R.id.txt_nationality);
         tvPoints = findViewById(R.id.txt_points);
         tvTeamCarImg = findViewById(R.id.img_team_car);
         tvTeamLogoImg = findViewById(R.id.img_team_logo);


        tvDrivers.setText(drivers.toString());
        tvName.setText(name);
        tvNationality.setText(nationality);
        tvPoints.setText(String.valueOf(points));
        Glide.with(this)
                .load(teamCarImg)
                .into(tvTeamCarImg);

        Glide.with(this)
                .load(teamLogoImg)
                .into(tvTeamLogoImg);

    }
}