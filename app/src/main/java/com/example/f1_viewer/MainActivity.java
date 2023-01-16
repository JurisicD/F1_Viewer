package com.example.f1_viewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.f1_viewer.Fragments.ChampionshipFragment;
import com.example.f1_viewer.Fragments.RaceTracksFragment;
import com.example.f1_viewer.Fragments.ScheduleFragment;
import com.example.f1_viewer.Fragments.UserSettingsFragment;
import com.example.f1_viewer.databinding.ActivityMainBinding;
import com.example.f1_viewer.Firebase.firebase_administration.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button btnLogOut;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);





        replaceFragment(new ChampionshipFragment()); //default fragment/main page

        mAuth = FirebaseAuth.getInstance();

        // view/fragment usage logic
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item->{

            switch (item.getItemId()){
                case R.id.miChampionship:
                    replaceFragment(new ChampionshipFragment());
                    break;
                case R.id.miSchedule:
                    replaceFragment(new ScheduleFragment());
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