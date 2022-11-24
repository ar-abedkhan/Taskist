package com.example.taskist.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.taskist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.todo.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MainToDoActivity.class));
        });
        binding.shoppingList.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, TodoView.class));
        });
        binding.note.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MainNoteActivity.class));
        });
    }
}