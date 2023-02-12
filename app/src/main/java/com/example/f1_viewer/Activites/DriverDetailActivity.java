package com.example.f1_viewer.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.f1_viewer.R;

public class DriverDetailActivity extends AppCompatActivity {

    TextView tvGivenName;
    ImageView tvPicture;
    TextView tvDriversWins;
    TextView tvDriversPodiums;
    TextView tvDriversPoles;
    TextView tvFirsEntry;
    TextView tvFirstWin;
    TextView tvNumberOfTitles;
    TextView tvCountry;
    TextView tvDateOfBirth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_detail_activitiy);

        Bundle bundle = getIntent().getExtras();
        String code = bundle.getString("code");
        String constructorId = bundle.getString("constructorId");
        String dateOfBirth = bundle.getString("dateOfBirth");
        String familyName = bundle.getString("familyName");
        String givenName = bundle.getString("givenName");
        String nationality = bundle.getString("nationality");
        int permanentNumber = bundle.getInt("permanentNumber");
        int wins = bundle.getInt("wins", 0);
        int podiums = bundle.getInt("podiums", 0);
        int poles = bundle.getInt("poles", 0);
        String firstEntry = bundle.getString("firstEntry");
        String firstWin = bundle.getString("firstWin");
        int numberOfTitles = bundle.getInt("numberOfTitles", 0);
        String picture = bundle.getString("picture");

        tvPicture = findViewById(R.id.driver_photo_image_view);
        tvGivenName = findViewById(R.id.driver_name_text_view);
        tvDriversWins = findViewById(R.id.textView_driver_number_wins);
        tvDriversPodiums = findViewById(R.id.textView_driver_number_podiums);
        tvDriversPoles = findViewById(R.id.textView_driver_number_poles);
        tvFirsEntry = findViewById(R.id.textView_driver_first_enty);
        tvFirstWin = findViewById(R.id.extView_driver_first_win);
        tvNumberOfTitles = findViewById(R.id.textView_number_of_titles);
        tvCountry = findViewById(R.id.textView_counry_born);
        tvDateOfBirth = findViewById(R.id.textView_driver_date_of_birth);

        tvGivenName.setText(givenName+" "+ familyName);
        Glide.with(this)
                .load(picture)
                .into(tvPicture);

        tvDriversWins.setText(String.valueOf(wins));
        tvDriversPodiums.setText(String.valueOf(podiums));
        tvDriversPoles.setText(String.valueOf(poles));
        tvFirsEntry.setText(firstEntry);
        tvFirstWin.setText(firstWin);
        tvNumberOfTitles.setText(String.valueOf(numberOfTitles));
        tvCountry.setText(nationality);
        tvDateOfBirth.setText(dateOfBirth);

    }
}