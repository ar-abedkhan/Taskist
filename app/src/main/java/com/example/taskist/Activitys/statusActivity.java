package com.example.taskist.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.taskist.adapters.StatusAdapter;
import com.example.taskist.databinding.ActivityStatusBinding;

public class statusActivity extends AppCompatActivity {
ActivityStatusBinding binding;
FragmentManager fragmentManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        fragmentManager=getSupportFragmentManager();
//        statusAdapter = new StatusAdapter(fragmentManager,100);
//        binding.statusviewPager.setAdapter(statusAdapter);
//        binding.statustablayout.setupWithViewPager(binding.statusviewPager);
//
//
//















    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(statusActivity.this, MainToDoActivity.class));
        super.onBackPressed();
    }
}