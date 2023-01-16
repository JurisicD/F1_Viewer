package com.example.f1_viewer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Firebase.GetData.FirebaseDatabaseHelper;
import com.example.f1_viewer.Firebase.GetData.ReadDB;
import com.example.f1_viewer.R;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipFragment extends Fragment {
    Button btn_ShowDriversView, btn_ShowConstructorView;
    RecyclerView mRecyclerView;
    private List<Driver> driverList = new ArrayList<>();

    private List<String> driverData = new ArrayList<>();
    private List<String> constructorData = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View contentView = inflater.inflate(R.layout.fragment_championship,
                                                container, false);
       

        return contentView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //CODE GOES HERE!
        btn_ShowDriversView = view.findViewById(R.id.btn_ShowDriversView);
        btn_ShowConstructorView = view.findViewById(R.id.btn_ShowConstructorView);
        mRecyclerView = view.findViewById(R.id.recyclerView);









        popuni();

        btn_ShowDriversView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateListView(driverData);
            }
        });

        btn_ShowConstructorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateListView(constructorData);
            }
        });


    }

    private void updateListView(List<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, data);
        mRecyclerView.setAdapter(adapter);
    }

    private void popuni(){


        Driver driver1 = new Driver("DRV01", "CON01", "1980-01-01", "1", "Hamilton", "Lewis", "British", "44", "https://example.com/drivers/1");
        Driver driver2 = new Driver("DRV02", "CON02", "1985-03-03", "2", "Verstappen", "Max", "Dutch", "33", "https://example.com/drivers/2");
        Driver driver3 = new Driver("DRV03", "CON03", "1990-05-05", "3", "Leclerc", "Charles", "Monacan", "16", "https://example.com/drivers/3");

        driverList.add(driver1);
        driverList.add(driver2);
        driverList.add(driver3);

        driverData.add("Lewis Hamilton");
        driverData.add("Valtteri Bottas");
        driverData.add("Max Verstappen");
        driverData.add("Sebastian Vettel");
        driverData.add("Charles Leclerc");

        constructorData.add("Mercedes");
        constructorData.add("Red Bull Racing");
        constructorData.add("Ferrari");
        constructorData.add("McLaren");
        constructorData.add("Alfa Romeo Racing");
        constructorData.add("Mercedes");
        constructorData.add("Red Bull Racing");
        constructorData.add("Ferrari");
        constructorData.add("McLaren");
        constructorData.add("Alfa Romeo Racing");
        constructorData.add("Mercedes");
        constructorData.add("Red Bull Racing");
        constructorData.add("Ferrari");
        constructorData.add("McLaren");
        constructorData.add("Alfa Romeo Racing");
        constructorData.add("Mercedes");
        constructorData.add("Red Bull Racing");
        constructorData.add("Ferrari");
        constructorData.add("McLaren");
        constructorData.add("Alfa Romeo Racing");
        constructorData.add("Mercedes");
        constructorData.add("Red Bull Racing");
        constructorData.add("Ferrari");
        constructorData.add("McLaren");
        constructorData.add("Alfa Romeo Racing");
        constructorData.add("Mercedes");
        constructorData.add("Red Bull Racing");
        constructorData.add("Ferrari");
        constructorData.add("McLaren");
        constructorData.add("Alfa Romeo Racing");

    }

}