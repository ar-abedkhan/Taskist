package com.example.taskist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.taskist.databinding.ActivityMainToDoBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainToDoActivity extends AppCompatActivity {

    ActivityMainToDoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainToDoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainToDoActivity.this, MainActivity.class));
            finish();
        });

        binding.addBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainToDoActivity.this, ToDoAddActivity.class));
            finish();
        });

        binding.bottomMenu.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.bottomHome:
                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.bottomAll:
                    startActivity(new Intent(MainToDoActivity.this, AllListActivity.class));
                    finish();
                    break;
            }
            return true;
        });
    }
}