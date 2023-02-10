package com.example.f1_viewer.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        ArrayList<String> list = new ArrayList<>(); // race result by drivers from 1.st to last.
        list.add("Verstappen");
        list.add("Perez");

        raceList.add(new Race("SLika staze", "Bahrain"," Bahrain International Circuit","3.550 km","Round 1",
                "18-20 March","52","Lap Record: 1.35.455 Charles Leclerk(2018)",list));

        raceList.add(new Race("SLika staze", "Saudi Arabia"," Jeddah Coniche Circuit","3.550 km","Round 2",
                "22-27 April","52","Lap Record: 1.35.455 Charles Leclerk(2018)",list));

        raceList.add(new Race("SLika staze", "Australia"," Australian Grand Prix","3.550 km","Round 3",
                "08-10 April","52","Lap Record: 1.35.455 Charles Leclerk(2018)",list));
        raceList.add(new Race("SLika staze", "Italy"," Emilia Romanga Grand Prix","3.550 km","Round 4",
                "22-24 April","52","Lap Record: 1.35.455 Charles Leclerk(2018)",list));


        raceAdapter = new RaceAdapter(getContext(), raceList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(raceAdapter);

        return view;
    }
}




