package com.example.f1_viewer.Fragments;


import android.content.Context;
import android.os.Bundle;
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
import com.example.f1_viewer.Config.RecyclerView_ConfigDrivers;
import com.example.f1_viewer.Firebase.GetData.FirebaseDatabaseHelper;
import com.example.f1_viewer.MainActivity;
import com.example.f1_viewer.R;

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
        context = getActivity();
        //CODE GOES HERE!
        btn_ShowDriversView = view.findViewById(R.id.btn_ShowDriversView);
        btn_ShowConstructorView = view.findViewById(R.id.btn_ShowConstructorView);
        mRecyclerView = view.findViewById(R.id.recyclerView);



        new FirebaseDatabaseHelper().readDrivers(new FirebaseDatabaseHelper.DataStatusDrivers() {

            @Override

            public void DataIsLoaded(List<Driver> drivers, List<String> keys) {

                Toast.makeText(context, "uso", Toast.LENGTH_SHORT).show();
                new RecyclerView_ConfigDrivers().setConfig(mRecyclerView, context, drivers, keys);

            }
            @Override
            public void DataIsInserted() {

            }
            @Override
            public void DataIsUpdated() {

            }
            @Override
            public void DataIsDeleted() {

            }

        });
        btn_ShowDriversView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        btn_ShowConstructorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void updateListView(List<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, data);
        //mRecyclerView.setAdapter(adapter);
    }


}