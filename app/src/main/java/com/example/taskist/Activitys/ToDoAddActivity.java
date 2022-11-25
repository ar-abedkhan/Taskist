package com.example.taskist.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.taskist.R;
import com.example.taskist.databinding.ActivityToDoAddBinding;

public class ToDoAddActivity extends AppCompatActivity {

    ActivityToDoAddBinding binding;
    String msg="";
    String Priority;
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

//        ToDoModel note =new ToDoModel();
//        note.setTitle(Title);
//        note.setCategories(msg);
//        note.setPriority(Priority);
//        note.setParticipant(participant);
//        note.setLocation(location);
//        note.setDescription(Desctiption);
//        ToDoDatabase.getInstance(this).getToDoDao().insert(note);


    }

    private void radiogroup() {

        binding.priorityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.High:
                        Priority=  binding.High.getText().toString();
                        break;
                    case R.id.Medium:
                        Priority= binding.Medium.getText().toString();
                        break;
                    case R.id.Low:
                        Priority= binding.Low.getText().toString();
                        break;
                }

            }

        });
    }

    private void checkbox() {
        if(binding.wrokcheckbox.isChecked()){
            msg = msg + " Wrok,";
        }
        if(binding.personalcheckbox.isChecked()){
            msg = msg + " Personal,";
        }
        if(binding.shoppingcheckbox.isChecked()){
            msg = msg + " Shopping,";
        }
        if(binding.healthcheckbox.isChecked()){
            msg = msg + " Health,";
        }
        if(binding.otherCateCheckBox.isChecked()){
            //get data from custom category text view
            msg = msg + binding.otherCateField.getText().toString().trim();
        }
    }
}