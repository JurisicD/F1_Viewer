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
        String circuitName = bundle.getString("circuitName");
        String country = bundle.getString("country");
        String dateFromTo = bundle.getString("dateFromTo");
        String lapRecord = bundle.getString("lapRecord");
        int numberOfLaps = bundle.getInt("numberOfLaps", 0);
        double raceDistance = bundle.getDouble("raceDistance", 0.0);
        String round = bundle.getString("round");
        double trackDistance = bundle.getDouble("trackDistance", 0.0);
        String trackImg = bundle.getString("trackImg");
        String trackName = bundle.getString("trackName");


        tvTrackImg = findViewById(R.id.imageView_track_layout);
        tvCountry = findViewById(R.id.textView_track_county);
        tvCircuitName = findViewById(R.id.textView_cuircuit_name);
        tvTrackDistance = findViewById(R.id.textView_track_distance);
        tvRound = findViewById(R.id.textView_round_text);
        tvDateFromTo = findViewById(R.id.textView_date_from_to);
        tvNumberOfLaps = findViewById(R.id.textView_number_of_laps);
        tvRaceDistance = findViewById(R.id.textView_race_distance);
        tvLapRecord = findViewById(R.id.textView_lap_record);

       Glide.with(this)
                .load(trackImg)
               .into(tvTrackImg);
        tvCountry.setText(country);
        tvCircuitName.setText(circuitName);
        tvTrackDistance.setText(""+trackDistance+"km");
        tvRound.setText(round);
        tvDateFromTo.setText(dateFromTo);
        tvNumberOfLaps.setText(""+numberOfLaps);
        tvRaceDistance.setText(""+raceDistance+"km");
        tvLapRecord.setText(lapRecord);
    }
}