package com.example.f1_viewer.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.R;

import java.util.ArrayList;
import java.util.List;

public class TeamDetailActivity extends AppCompatActivity {

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




         tvName = findViewById(R.id.txt_name);
         tvNationality = findViewById(R.id.txt_nationality);
         tvPoints = findViewById(R.id.txt_points);
         tvTeamCarImg = findViewById(R.id.img_team_car);
         tvTeamLogoImg = findViewById(R.id.img_team_logo);
         tvDrivers  = findViewById(R.id.textView_drivers_team);




        String driverNames = TextUtils.join("\n\n ", drivers);
        tvDrivers.setText(driverNames);
        tvName.setText(name);
        tvNationality.setText(nationality);
        tvPoints.setText(String.valueOf(points)+"PTS");
        Glide.with(this)
                .load(teamCarImg)
                .into(tvTeamCarImg);

        Glide.with(this)
                .load(teamLogoImg)
                .into(tvTeamLogoImg);

    }

}