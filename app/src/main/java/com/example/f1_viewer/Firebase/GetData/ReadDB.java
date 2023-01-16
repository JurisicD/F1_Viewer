package com.example.f1_viewer.Firebase.GetData;


import androidx.annotation.NonNull;

import com.example.f1_viewer.Classes.Constructor;
import com.example.f1_viewer.Classes.ConstructorStandings;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Race;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadDB {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceConstructor,mReferenceConstructorStandings, mReferenceDriver, mReferenceRace;

    private List<Constructor> constructorList;
    private List<ConstructorStandings>constructorStandingsList;
    private List<Driver> driverList;
    private List<Race> raceList;

    public interface DataStatus{
        void DataIsLoaded(List<Driver> driverList, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public ReadDB(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceConstructor = mDatabase.getReference("2").child("ConstructorTable").child("Constructors");
        mReferenceConstructorStandings = mDatabase.getReference("3").child("StandingsTable").child("StandingsList");
        mReferenceDriver = mDatabase.getReference("0").child("DriverTable").child("Drivers");
        mReferenceRace = mDatabase.getReference("1").child("RaceTable").child("Races");
    }

    public void readDrivers(){
        mReferenceDriver.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                driverList.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Driver driver = keyNode.getValue(Driver.class);
                    driverList.add(driver);
                }
                //dataStatus.DataIsLoaded(driverList, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}