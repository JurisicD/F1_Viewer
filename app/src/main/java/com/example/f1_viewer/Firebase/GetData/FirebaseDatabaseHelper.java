package com.example.f1_viewer.Firebase.GetData;

import androidx.annotation.NonNull;

import com.example.f1_viewer.Classes.Driver;
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
    private DatabaseReference mReferenceTracks;
    private DatabaseReference mReferencesRaces;
    private List<Driver> drivers = new ArrayList<>();



    public interface DataStatus{
        void DataIsLoaded(List<Driver> drivers, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceDrivers = mDatabase.getReference("0").child("DriverTable").child("Drivers");
    }

    public void readDrivers(final DataStatus dataStatus){
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
}
