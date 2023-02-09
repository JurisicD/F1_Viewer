package com.example.f1_viewer.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Adapter.DriverAdapter;
import com.example.f1_viewer.Adapter.MyAdapter;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Config.RecyclerView_ConfigDrivers;
import com.example.f1_viewer.MainActivity;
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

    private RecyclerView mRecyclerView;
    ArrayList<Driver> driversList;

    MyAdapter adapter;
    private FirebaseDatabase mDatabase;
    public DatabaseReference mReferenceDrivers;


    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_championship, container, false);

        btn_ShowDriversView = view.findViewById(R.id.btn_ShowDriversView);
        btn_ShowConstructorView = view.findViewById(R.id.btn_ShowConstructorView);
        mRecyclerView = view.findViewById(R.id.recyclerView);

        driversList = new ArrayList<>();
        driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1",""));
        driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1",""));
        driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1",""));
        driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1",""));
        driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1",""));
        driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1",""));
        driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1",""));
        driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1",""));



        adapter = new MyAdapter(getContext(), driversList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

        return view;
    }


}




