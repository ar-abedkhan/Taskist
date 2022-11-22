package com.example.taskist.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.taskist.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {

    ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        checking the first time install done by rafi

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun ==true) {
            binding.startBtn.setOnClickListener(view -> {
                Intent intent =new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            });
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();

        if (isFirstRun==false) {
            Intent intent1 =new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent1);
            finish();
        }
    }
}