package com.example.f1_viewer.Fragments;

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

import com.example.f1_viewer.Adapter.DriverAdapter;
import com.example.f1_viewer.Adapter.RaceAdapter;
import com.example.f1_viewer.Adapter.TeamAdapter;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Race;
import com.example.f1_viewer.Classes.Team;
import com.example.f1_viewer.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ScheduleFragment extends Fragment {

    private RecyclerView mRecyclerView;

    ArrayList<Race> raceList;
    RaceAdapter raceAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView_Schedule);

        raceList = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Race");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String circuitName = childSnapshot.child("circuitName").getValue(String.class);
                    String country = childSnapshot.child("country").getValue(String.class);
                    String dateFromTo = childSnapshot.child("dateFromTo").getValue(String.class);
                    String lapRecord = childSnapshot.child("lapRecord").getValue(String.class);
                    int numberOfLaps = childSnapshot.child("numberOfLaps").getValue(Integer.class);
                    double raceDistance = childSnapshot.child("raceDistance").getValue(Double.class);
                    String round = childSnapshot.child("round").getValue(String.class);
                    double trackDistance = childSnapshot.child("trackDistance").getValue(Double.class);
                    String trackImg = childSnapshot.child("trackImg").getValue(String.class);
                    String trackName = childSnapshot.child("trackName").getValue(String.class);

                    raceList.add(new Race(circuitName, country, dateFromTo, lapRecord, numberOfLaps, raceDistance, round, trackDistance, trackImg, trackName));
                }


                raceAdapter = new RaceAdapter(getContext(), raceList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(raceAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException());
            }
        });

        return view;
    }

}




