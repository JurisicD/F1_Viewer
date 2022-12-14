package com.example.f1_viewer.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.f1_viewer.MainActivity;
import com.example.f1_viewer.R;
import com.example.f1_viewer.firebase_administration.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;


public class DriversStandingFragment extends Fragment {

    Button test;
    FirebaseAuth mAuth;
    TextView twTest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drivers_standing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        twTest = view.findViewById(R.id.textView1);
        twTest.setText("JAVVA");

    }
}