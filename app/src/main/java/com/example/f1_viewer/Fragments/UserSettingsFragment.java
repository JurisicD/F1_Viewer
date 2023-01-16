package com.example.f1_viewer.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.f1_viewer.R;
import com.example.f1_viewer.Firebase.firebase_administration.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;


public class UserSettingsFragment extends Fragment {

    Button logout;
    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //User settings
        logout= (Button) view.findViewById(R.id.btnLogout);
        logout.setOnClickListener(view1 -> {
            mAuth = FirebaseAuth.getInstance();
            mAuth.signOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
    }


}