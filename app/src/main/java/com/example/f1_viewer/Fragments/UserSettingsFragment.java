package com.example.f1_viewer.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.f1_viewer.Adapter.AdapterPoints;
import com.example.f1_viewer.Adapter.DriverAdapter;
import com.example.f1_viewer.Adapter.RaceAdapter;
import com.example.f1_viewer.Adapter.TeamAdapter;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Race;
import com.example.f1_viewer.Classes.Team;
import com.example.f1_viewer.R;
import com.example.f1_viewer.Firebase.firebase_administration.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class UserSettingsFragment extends Fragment {

    Button logout;
    FirebaseAuth mAuth;

    ArrayList<Team> teamList;
    ArrayList<Driver> driverList;

    AdapterPoints adapter;

    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_user_settings, container, false);
    }

    private void reloadData() {
        getData();
    }

    @Override
    public void onResume() {
        super.onResume();
        reloadData();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        mRecyclerView = view.findViewById(R.id.admin_reclycer);
      //  getData();


        //User settings
        logout= (Button) view.findViewById(R.id.btnLogout);
        logout.setOnClickListener(view1 -> {
            mAuth = FirebaseAuth.getInstance();
            mAuth.signOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
    }



    private void getData(){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Team");
        DatabaseReference myRef2 = database.getReference("Driver");
        driverList = new ArrayList<>();
        myRef2.addValueEventListener(new ValueEventListener() {
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
                    int wins = childSnapshot.child("wins").getValue(Integer.class);
                    int podiums = childSnapshot.child("podiums").getValue(Integer.class);
                    int poles = childSnapshot.child("poles").getValue(Integer.class);
                    String firstEntry = childSnapshot.child("firstEntry").getValue(String.class);
                    String firstWin = childSnapshot.child("firstWin").getValue(String.class);
                    int numberOfTitles = childSnapshot.child("numberOfTitles").getValue(Integer.class);
                    String picture = childSnapshot.child("picture").getValue(String.class);
                    int points = childSnapshot.child("points").getValue(Integer.class);

                    driverList.add(new Driver(code, constructorId, dateOfBirth, familyName, givenName, nationality, permanentNumber, wins, podiums, poles, firstEntry, firstWin, numberOfTitles, picture,points));
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException());
            }
        });

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

                    Collections.sort(teamList, new Comparator<Team>() {
                        @Override
                        public int compare(Team o1, Team o2) {
                            return Double.compare(o2.getPoints(), o1.getPoints());
                        }
                    });


                    adapter = new AdapterPoints(getContext(), teamList, driverList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setAdapter(adapter);

                }
                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("Firebase", "Failed to read value.", error.toException());
                }
            });
    }


}