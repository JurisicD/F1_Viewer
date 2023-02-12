package com.example.f1_viewer.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.f1_viewer.Classes.Race;
import com.example.f1_viewer.R;

public class RaceDetailActivity extends AppCompatActivity {

    TextView tvCircuitName;
    TextView tvCountry;
    TextView tvDateFromTo;
    TextView tvLapRecord;
    TextView tvNumberOfLaps;
    TextView tvRaceDistance;
    TextView tvRound;
    TextView tvTrackDistance;
    ImageView tvTrackImg;
    TextView tvTrackName;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_detail);

        Bundle bundle = getIntent().getExtras();
        Race race = bundle.getParcelable("race");
/*
        tvCircuitName = findViewById(R.id.txt_circuit_name_text);
        tvCountry = findViewById(R.id.txt_country_text);
        tvDateFromTo = findViewById(R.id.txt_date_from_to_text);
        tvLapRecord = findViewById(R.id.txt_lap_record_text);
        tvNumberOfLaps = findViewById(R.id.txt_number_of_laps_text);
        tvRaceDistance = findViewById(R.id.txt_race_distance_text);
        tvRound = findViewById(R.id.txt_round_text);
        tvTrackDistance = findViewById(R.id.txt_track_distance_text);
        tvTrackImg = findViewById(R.id.img_track_text);
        tvTrackName = findViewById(R.id.txt_track_name_text);

        tvCircuitName.setText(race.getCircuitName());
        tvCountry.setText(race.getCountry());
        tvDateFromTo.setText(race.getDateFromTo());
        tvLapRecord.setText(race.getLapRecord());
        tvNumberOfLaps.setText(String.valueOf(race.getNumberOfLaps()));
        tvRaceDistance.setText(String.valueOf(race.getRaceDistance()));
        tvRound.setText(race.getRound());
        tvTrackDistance.setText(String.valueOf(race.getTrackDistance()));
        tvTrackName.setText(race.getTrackName());
        Glide.with(this)
                .load(race.getTrackImg())
                .into(tvTrackImg);


*/

    }
}