package com.example.taskist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.taskist.databinding.ActivityToDoAddBinding;

public class ToDoAddActivity extends AppCompatActivity {

    ActivityToDoAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToDoAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backBtn.setOnClickListener(view -> {
            startActivity(new Intent(ToDoAddActivity.this, MainToDoActivity.class));
            finish();
        });

        binding.otherCateCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true){
                    binding.otherCateField.setVisibility(View.VISIBLE);
                }else {
                    binding.otherCateField.setVisibility(View.GONE);
                }
            }
        });

    }
}