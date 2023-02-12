package com.example.f1_viewer;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.f1_viewer.Classes.Team;
import com.example.f1_viewer.Fragments.ChampionshipFragment;
import com.example.f1_viewer.Fragments.ScheduleFragment;
import com.example.f1_viewer.Fragments.UserSettingsFragment;
import com.example.f1_viewer.databinding.ActivityMainBinding;
import com.example.f1_viewer.Firebase.firebase_administration.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        replaceFragment(new ScheduleFragment()); //default fragment/main page

        mAuth = FirebaseAuth.getInstance();

        // view/fragment usage logic
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item->{

            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.miChampionship:
                    replaceFragment(new ChampionshipFragment());
                    break;
                case R.id.miSchedule:
                    replaceFragment(new ScheduleFragment());
                    break;
                case R.id.miUserSettings:
                    replaceFragment(new UserSettingsFragment());
                    break;
            }
            if (selectedFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                transaction.replace(R.id.fragContent, selectedFragment);
                transaction.commit();
            }
            return true;
        });
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