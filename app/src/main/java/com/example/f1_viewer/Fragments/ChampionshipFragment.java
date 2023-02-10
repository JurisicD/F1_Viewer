package com.example.f1_viewer.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Adapter.DriverAdapter;
import com.example.f1_viewer.Adapter.TeamAdapter;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Team;
import com.example.f1_viewer.R;

import java.util.ArrayList;

public class ChampionshipFragment extends Fragment  {

    private RecyclerView mRecyclerView;

    Button btn_ShowDriversView, btn_ShowConstructorView;
    ArrayList<Driver> driversList;
    DriverAdapter driverAdapter;

    ArrayList<Team> teamList;
    TeamAdapter teamAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_championship, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);

        btn_ShowDriversView = view.findViewById(R.id.btn_ShowDriversView);
        btn_ShowConstructorView = view.findViewById(R.id.btn_ShowConstructorView);


        driversList = new ArrayList<>();

        btn_ShowDriversView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1"));
                driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1"));
                driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1"));
                driversList.add(new Driver("VER", "Red Bull", "01.01.2022", "verstapen", "Verstappen","Max","Duch","1"));


                driverAdapter = new DriverAdapter(getContext(), driversList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(driverAdapter);

            }
        });

        teamList = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("Verstappen");
        list.add("Perez");

        btn_ShowConstructorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamList.add(new Team("alfa", "Alfa Romeo", "Swiss", "250", list ));
                teamList.add(new Team("alfa", "Alfa Romeo", "Swiss", "250", list ));
                teamList.add(new Team("alfa", "Alfa Romeo", "Swiss", "250", list ));
                teamList.add(new Team("alfa", "Alfa Romeo", "Swiss", "250", list ));

                teamAdapter = new TeamAdapter(getContext(), teamList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(teamAdapter);


            }
        });

        return view;
    }
}




