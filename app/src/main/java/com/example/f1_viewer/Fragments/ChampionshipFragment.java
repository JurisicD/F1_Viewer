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
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.DriverAdapter;
import com.example.f1_viewer.Config.RecyclerView_ConfigDrivers;
import com.example.f1_viewer.Firebase.GetData.FirebaseDatabaseHelper;
import com.example.f1_viewer.MainActivity;
import com.example.f1_viewer.R;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipFragment extends Fragment  {

    Button btn_ShowDriversView, btn_ShowConstructorView;
    private RecyclerView mRecyclerViewConstructors;
    ConstraintLayout constraintLayoutDriver;

    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View contentView = inflater.inflate(R.layout.fragment_championship,
                                                container, false);
        return contentView;
    }

    private Context context;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //CODE GOES HERE!
        btn_ShowDriversView = view.findViewById(R.id.btn_ShowDriversView);
        btn_ShowConstructorView = view.findViewById(R.id.btn_ShowConstructorView);



        List<Driver> drivers = new ArrayList<>();
        List<String> keys = new ArrayList<>();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        DriverAdapter adapter = new DriverAdapter(getActivity(), drivers, keys);
        recyclerView.setAdapter(adapter);

        Toast.makeText(getActivity() , "USO", Toast.LENGTH_SHORT).show();
        FirebaseDatabaseHelper databaseHelper = new FirebaseDatabaseHelper();
        databaseHelper.readDrivers(new FirebaseDatabaseHelper.DataStatusDrivers() {
            @Override
            public void DataIsLoaded(List<Driver> drivers, List<String> keys) {
                //Update the adapter with the new data and notify it that the data has changed

                adapter.updateData(drivers, keys);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void DataIsInserted() {}
            @Override
            public void DataIsUpdated() {}
            @Override
            public void DataIsDeleted() {}
        });

    }

    @Override
    public void onStop() {
        super.onStop();
      //  databaseHelper.mReferenceDrivers.removeEventListener();
    }
}




