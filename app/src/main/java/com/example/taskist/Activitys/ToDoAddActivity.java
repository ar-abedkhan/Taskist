package com.example.taskist.Activitys;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.taskist.Database.ToDoDatabase;
import com.example.taskist.Database.ToDoModel;
import com.example.taskist.R;
import com.example.taskist.databinding.ActivityToDoAddBinding;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ToDoAddActivity extends AppCompatActivity {

    ActivityToDoAddBinding binding;
    String msg="";
    String Priority;
    String participant;
    Calendar cal;
    Calendar calendar;
    int year,day,month, mHour, mMinute;
    TimePickerDialog   timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToDoAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cal = Calendar.getInstance();
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

        Starttime();
        Endtime();
        Startdate();
        Enddate();

        //insert btn
        binding.insertBtn.setOnClickListener(view -> {
            if (validateFields()){
                Collectdatafromuser();
                Log.i("TAG", "onCreate: "+Priority);
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
//        else if(Priority.equalsIgnoreCase("")) {
//            Toast.makeText(this, "Please check your Priority ", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        else if(binding.insertTaskDesctiption.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "Please enter a valid description", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }
    private void Collectdatafromuser() {
        String Title = binding.insertTaskTitle.getText().toString();
        checkbox();
        radiogroup();
        String Start_time=binding.startTimeTV.getText().toString();
        String end_time=binding.endTimeTV.getText().toString();
        String Start_date=binding.startDate.getText().toString();
        String end_date=binding.endDateTV.getText().toString();
        String location=  binding.locationEditText.getText().toString();
        String Desctiption=  binding.insertTaskDesctiption.getText().toString();

        //inser data to database
        ToDoModel note =new ToDoModel();
        note.setTitle(Title);
        note.setCategories(msg);
        note.setPriority(Priority);
        note.setStartTime(Start_time);
        note.setEndTime(end_time);
        note.setStartdate(Start_date);
        note.setEnddate(end_date);
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

    public void Starttime(){

        binding.startTimeTV.setOnClickListener(view -> {
            mHour = cal.get(Calendar.HOUR_OF_DAY);
            mMinute = cal.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
                timePickerDialog = new TimePickerDialog(this,
                    (view12, hourOfDay, minute) -> {
                        binding.startTimeTV.setText(StartTime(hourOfDay, minute));
                        timePickerDialog.dismiss();
                    }, mHour, mMinute, false);

            timePickerDialog.show();


        });
    }
    private void Endtime() {
        binding.endTimeTV.setOnClickListener(view -> {
            mHour = cal.get(Calendar.HOUR_OF_DAY);
            mMinute = cal.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            timePickerDialog = new TimePickerDialog(this,
                    (view12, hourOfDay, minute) -> {
                        binding.endTimeTV.setText(StartTime(hourOfDay, minute));
                        timePickerDialog.dismiss();
                    }, mHour, mMinute, false);

            timePickerDialog.show();


        });

    }

    private void Startdate() {
        binding.startDate.setOnClickListener(v -> {

            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    ToDoAddActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            binding.startDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    },
                    year, month, day);
            datePickerDialog.show();
        });
    }

    private void Enddate() {
        binding.endDateTV.setOnClickListener(v -> {
//            calendar = Calendar.getInstance();
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    ToDoAddActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            binding.endDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    },
                    year, month, day);
            datePickerDialog.show();
        });
    }

    private String StartTime(int hourOfDay, int minute) {
        Time tme = new Time(hourOfDay, minute, 0);//seconds by default set to zero
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        return formatter.format(tme);
    }
}