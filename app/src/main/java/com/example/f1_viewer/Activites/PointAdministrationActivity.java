package com.example.f1_viewer.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.f1_viewer.Adapter.AdapterPoints;
import com.example.f1_viewer.Adapter.FilteredDriversAdapter;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Team;
import com.example.f1_viewer.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class PointAdministrationActivity extends AppCompatActivity {

    ArrayList<Driver>drivers;
    FilteredDriversAdapter adapter;
    AdapterPoints adapterPoint;
    RecyclerView mRecyclerView;

    ArrayList<Team> teamList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poit_administration_activitiy);

        Intent intent = getIntent();
        String  constructorId = intent.getStringExtra("constructorId");
        ArrayList<String> drivers = intent.getStringArrayListExtra("drivers");
        String name = intent.getStringExtra("name");
        String nationality = intent.getStringExtra("nationality");
        double points = intent.getDoubleExtra("points", 0.0);
        String teamCarImg = intent.getStringExtra("teamCarImg");
        String teamLogoImg = intent.getStringExtra("teamLogoImg");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Driver");
        ArrayList<Driver> filteredDriverList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.filteredDriversViewRecycler);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String constructorIdFromDB = childSnapshot.child("constructorId").getValue(String.class);

                    if (childSnapshot.child("constructorId" ).getValue(String.class).equals(name)) {
                        String code = childSnapshot.child("code").getValue(String.class);
                        String dateOfBirth = childSnapshot.child("dateOfBirth").getValue(String.class);
                        String familyName = childSnapshot.child("familyName").getValue(String.class);
                        String givenName = childSnapshot.child("givenName").getValue(String.class);
                        String nationality = childSnapshot.child("nationality").getValue(String.class);
                        int permanentNumber = childSnapshot.child("permanentNumber").getValue(Integer.class);
                        int wins = childSnapshot.child("wins").getValue(Integer.class);
                        int podiums = childSnapshot.child("podiums").getValue(Integer.class);
                        int poles = childSnapshot.child("poles").getValue(Integer.class);
                        String firstEntry = childSnapshot.child("firstEntry").getValue(String.class);
                        String firstWin = childSnapshot.child("firstWin").getValue(String.class);
                        int numberOfTitles = childSnapshot.child("numberOfTitles").getValue(Integer.class);
                        String picture = childSnapshot.child("picture").getValue(String.class);
                        int points = childSnapshot.child("points").getValue(Integer.class);

                        filteredDriverList.add(new Driver(code, constructorIdFromDB, dateOfBirth, familyName, givenName, nationality, permanentNumber, wins, podiums, poles, firstEntry, firstWin, numberOfTitles, picture,points));
                    }
                }
                if (adapter != null) {
                    adapter.clearData();
                    finish();
                } else {
                    adapter = new FilteredDriversAdapter(filteredDriverList, PointAdministrationActivity.this);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PointAdministrationActivity.this, LinearLayoutManager.VERTICAL, false);
                    mRecyclerView.setLayoutManager(layoutManager);
                }

                mRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException());
            }
        });
    }


}