package com.example.f1_viewer.Fragments;


import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Adapter.DriverAdapter;
import com.example.f1_viewer.Adapter.TeamAdapter;
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

public class ChampionshipFragment extends Fragment  {

    Button btn_ShowDriversView, btn_ShowConstructorView;
    RecyclerView mRecyclerView;
    ArrayList<Driver> driversList;
    DriverAdapter driverAdapter;

    ArrayList<Team> teamList;

    ArrayList<Team> teamsList;
    TeamAdapter teamAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_championship, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);


        btn_ShowDriversView = view.findViewById(R.id.btn_ShowDriversView);
        btn_ShowConstructorView = view.findViewById(R.id.btn_ShowConstructorView);



        btn_ShowDriversView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Driver");

                driversList = new ArrayList<>();
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                            String code = childSnapshot.child("code").getValue(String.class);
                            String constructorId = childSnapshot.child("constructorId").getValue(String.class);
                            String dateOfBirth = childSnapshot.child("dateOfBirth").getValue(String.class);
                            String familyName = childSnapshot.child("familyName").getValue(String.class);
                            String givenName = childSnapshot.child("givenName").getValue(String.class);
                            String nationality = childSnapshot.child("nationality").getValue(String.class);
                            int permanentNumber = childSnapshot.child("permanentNumber").getValue(Integer.class);
                            String picture = childSnapshot.child("picture").getValue(String.class);

                            driversList.add(new Driver(code, constructorId, dateOfBirth, familyName, givenName, nationality, permanentNumber, picture));
                        }

                        driverAdapter = new DriverAdapter(getContext(), driversList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setAdapter(driverAdapter);
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Firebase", "Failed to read value.", error.toException());
                    }
                });
            }
        });

        btn_ShowConstructorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Team");

                teamList = new ArrayList<>();
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                            int constructorId = childSnapshot.child("constructorId").getValue(Integer.class);
                            ArrayList<String> drivers = new ArrayList<>();
                            for (DataSnapshot driverSnapshot : childSnapshot.child("drivers").getChildren()) {
                                String driver = driverSnapshot.child("driver").getValue(String.class);
                                drivers.add(driver);
                            }
                            String name = childSnapshot.child("name").getValue(String.class);
                            String nationality = childSnapshot.child("nationality").getValue(String.class);
                            double points = childSnapshot.child("points").getValue(Double.class);
                            String teamCarImg = childSnapshot.child("teamCarImg").getValue(String.class);
                            String teamLogoImg = childSnapshot.child("teamLogoImg").getValue(String.class);

                            teamList.add(new Team(constructorId, drivers, name, nationality, points, teamCarImg, teamLogoImg));
                        }

                        teamAdapter = new TeamAdapter(getContext(), teamList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setAdapter(teamAdapter);
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Firebase", "Failed to read value.", error.toException());
                    }
                });

            }
        });

        btn_ShowConstructorView.performClick();

        return view;
    }}








