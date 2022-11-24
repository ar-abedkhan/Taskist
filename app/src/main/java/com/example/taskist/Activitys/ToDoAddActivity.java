package com.example.taskist.Activitys;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.taskist.Database.ToDoDatabase;
import com.example.taskist.Database.ToDoModel;
import com.example.taskist.R;
import com.example.taskist.databinding.ActivityToDoAddBinding;

public class ToDoAddActivity extends AppCompatActivity {

    ActivityToDoAddBinding binding;
    String msg="";
    String Priority;
    String participant;
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

        binding.participantAddBtn.setOnClickListener(view -> {
            participant=  binding.participantEditText.getText().toString();
        });

        binding.insertBtn.setOnClickListener(view -> {
            if (validateFields()){
                Collectdatafromuser();
                Log.i("TAG", "onCreate: "+msg);
                startActivity(new Intent(this,MainToDoActivity.class));
                finish();
            }


        });


    }
    //Checking all the data filled by the user
    public boolean validateFields() {
        if(binding.insertTaskTitle.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "Please enter a valid title", Toast.LENGTH_SHORT).show();
            return false;
        }
//        else if(Priority.equals("")) {
//            Toast.makeText(this, "Please check your Priority ", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        else if(participant.equalsIgnoreCase("")) {
//            Toast.makeText(this, "Please add any participant name ", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        else if(binding.insertTaskDesctiption.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "Please enter a valid description", Toast.LENGTH_SHORT).show();
            return false;
        }
//        else if(binding.locationEditText.getText().toString().equalsIgnoreCase("")) {
//            Toast.makeText(this, "Please enter the valid location", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        else {
            return true;
        }
    }
    private void Collectdatafromuser() {
        String Title = binding.insertTaskTitle.getText().toString();
        checkbox();
        radiogroup();
        String location=  binding.locationEditText.getText().toString();
        String Desctiption=  binding.insertTaskDesctiption.getText().toString();

        //inser data to database
        ToDoModel note =new ToDoModel();
        note.setTitle(Title);
        note.setCategories(msg);
        note.setPriority(Priority);
        note.setParticipant(participant);
        note.setLocation(location);
        note.setDescription(Desctiption);
        ToDoDatabase.getInstance(ToDoAddActivity.this).getToDoDao().insert(note);


    }


    //collect radio group
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