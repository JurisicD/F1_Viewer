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

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceDrivers;
    private DatabaseReference mReferenceConstructors;
    private DatabaseReference mReferencesRaces;
    private DatabaseReference mReferenceConstructorStandings;


    private List<Driver> drivers = new ArrayList<>();
    private List<Constructor> constructors = new ArrayList<>();
    private List<ConstructorStandings> constructorStandings = new ArrayList<>();
    private List<Race> races = new ArrayList<>();

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceDrivers = mDatabase.getReference("0").child("DriverTable").child("Drivers");
        mReferenceConstructors = mDatabase.getReference("2").child("ConstructorTable").child("Constructors");
        mReferenceConstructorStandings = mDatabase.getReference("3").child("StandingsTable").child("StandingsLists");
        mReferencesRaces = mDatabase.getReference("1").child("RaceTable").child("Races");
    }

    public interface DataStatusDrivers{
        void DataIsLoaded(List<Driver> drivers, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public void readDrivers(final DataStatusDrivers dataStatus){
        mReferenceDrivers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                drivers.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Driver driver = keyNode.getValue(Driver.class);
                    drivers.add(driver);
                }
                dataStatus.DataIsLoaded(drivers, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public interface DataStatusConstructors{
        void DataIsLoaded(List<Constructor> constructors, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public void readConstructors(final DataStatusConstructors dataStatus){
        mReferenceConstructors.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                constructors.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Constructor constructor = keyNode.getValue(Constructor.class);
                    constructors.add(constructor);
                }
                dataStatus.DataIsLoaded(constructors, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public interface DataStatusConstructorStandings{
        void DataIsLoaded(List<ConstructorStandings> constructorStandings, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public void readConstructorsStandings(final DataStatusConstructorStandings dataStatus){
        mReferenceConstructorStandings.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                constructorStandings.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    ConstructorStandings constructorStandingss = keyNode.getValue(ConstructorStandings.class);
                    constructorStandings.add(constructorStandingss);
                }
                dataStatus.DataIsLoaded(constructorStandings, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public interface DataStatusRaces{
        void DataIsLoaded(List<Race> races, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public void readRaces(final DataStatusRaces dataStatus){
        mReferencesRaces.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                races.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Race race = keyNode.getValue(Race.class);
                    races.add(race);
                }
                dataStatus.DataIsLoaded(races, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
