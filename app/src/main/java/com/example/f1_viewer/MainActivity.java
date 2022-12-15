package com.example.f1_viewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.f1_viewer.Fragments.ConstructorsStandingsFragment;
import com.example.f1_viewer.Fragments.DriversStandingFragment;
import com.example.f1_viewer.Fragments.RaceTracksFragment;
import com.example.f1_viewer.Fragments.UserSettingsFragment;
import com.example.f1_viewer.databinding.ActivityMainBinding;
import com.example.f1_viewer.firebase_administration.LoginActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button btnLogOut, btnDriversStandingFragment, btnConstructorsStandingsFragment, btnRaceTracksFragment, btnUserSettingsFragment;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new DriversStandingFragment()); //default fragment/main page

        mAuth = FirebaseAuth.getInstance();

        // view/fragment usage logic
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item->{

            switch (item.getItemId()){
                case R.id.miChampionship:
                    replaceFragment(new DriversStandingFragment());
                    break;
                case R.id.miSchedule:
                    replaceFragment(new ConstructorsStandingsFragment());
                    break;
                case R.id.miRaceTracks:
                    replaceFragment(new RaceTracksFragment());
                    break;
                case R.id.miUserSettings:
                    replaceFragment(new UserSettingsFragment());
                    break;
            }
            return true;
        });


        /* Logout function
        btnLogOut = findViewById(R.id.btnLogout);

        btnLogOut.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragContent, fragment);
        fragmentTransaction.commit();
    }
}