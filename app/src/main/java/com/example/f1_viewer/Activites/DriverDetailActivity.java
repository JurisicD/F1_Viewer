package com.example.f1_viewer.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.f1_viewer.R;

public class DriverDetailActivity extends AppCompatActivity {

    TextView tvCode;
    TextView tvConstructorId;
    TextView tvDateOfBirth;
    TextView tvFamilyName;
    TextView tvGivenName;
    TextView tvNationality;
    TextView tvPermanentNumber;
    ImageView tvPicture;

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
        int permanentNumber = bundle.getInt("permanentNumber", 0);
        String picture = bundle.getString("picture");

        //tvCode = findViewById(R.id.txt_code);
        //tvConstructorId = findViewById(R.id.txt_constructor_id);
        //tvDateOfBirth = findViewById(R.id.txt_date_of_birth);
       // tvFamilyName = findViewById(R.id.txt_family_name);
        tvGivenName = findViewById(R.id.driver_name_text_view);
       // tvNationality = findViewById(R.id.txt_nationality);
        //tvPermanentNumber = findViewById(R.id.txt_permanent_number);
        tvPicture = findViewById(R.id.driver_photo_image_view);

        //tvCode.setText(code);
        //tvConstructorId.setText(constructorId);
       // tvDateOfBirth.setText(dateOfBirth);
        //tvFamilyName.setText(familyName);
        tvGivenName.setText(givenName+" "+ familyName);
        //tvNationality.setText(nationality);
       // tvPermanentNumber.setText(String.valueOf(permanentNumber));
        Glide.with(this)
                .load(picture)
                .into(tvPicture);
    }
}