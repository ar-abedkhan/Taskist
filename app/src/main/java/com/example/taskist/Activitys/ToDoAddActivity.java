package com.example.taskist.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.taskist.R;
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

        //done by rafi

        binding.insertBtn.setOnClickListener(view -> {
            Collectdatafromuser();
        });


    }

    private void Collectdatafromuser() {
        String Title = binding.insertTaskTitle.getText().toString();
        checkbox();
        radiogroup();
      String participant=  binding.participantEditText.getText().toString();
      String location=  binding.locationEditText.getText().toString();
      String Desctiption=  binding.insertTaskDesctiption.getText().toString();
    }

    private void radiogroup() {

        binding.priorityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radio0:
                   String High= binding.radio0.getText().toString();
                        break;
                    case R.id.radio1:
                        String Medium= binding.radio0.getText().toString();

                        break;
                    case R.id.radio2:
                        String Low= binding.radio0.getText().toString();
                        break;
                }
            }
        });
    }

    private void checkbox() {
        String msg="";
        if(binding.wrokcheckbox.isChecked()){
            msg = msg + " Wrok ";
        }
        if(binding.personalcheckbox.isChecked()){
            msg = msg + " Personal ";
        }
        if(binding.shoppingcheckbox.isChecked()){
            msg = msg + " Shopping ";
        }
        if(binding.healthcheckbox.isChecked()){
            msg = msg + " Health ";
        }
        Log.i("TAG", "checkbox: "+msg);

    }
}