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

import com.example.f1_viewer.Adapter.MyAdapter;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Vozac;
import com.example.f1_viewer.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ScheduleFragment extends Fragment {

    private RecyclerView mRecyclerView;
    ArrayList<Driver> driversList;

    MyAdapter adapter;
    private FirebaseDatabase mDatabase;
    public DatabaseReference mReferenceDrivers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        mRecyclerView = view.findViewById(R.id.recyclerView_Schedule);

        driversList = new ArrayList<>();
        driversList.add(new Driver("12", "red", "12", "12", "ver","max","212","das","12"));


        adapter = new MyAdapter(getContext(), driversList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

      
    }



}