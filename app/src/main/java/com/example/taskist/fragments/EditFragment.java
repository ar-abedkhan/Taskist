package com.example.taskist.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.taskist.Activitys.ToDoAddActivity;
import com.example.taskist.Database.ToDoDatabase;
import com.example.taskist.Database.ToDoModel;
import com.example.taskist.R;
import com.example.taskist.databinding.FragmentEditBinding;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditFragment extends Fragment {


    public EditFragment() {

    }
//    ---------- @Zeeshan


    FragmentEditBinding binding;
    Intent intent;
    List<ToDoModel> modelList;
    int currentID;
    String taskPriority, myCategories="";
    boolean statusIsDone;

    Calendar cal;
    int year,day,month, mHour, mMinute,selectedId;
    TimePickerDialog   timePickerDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentEditBinding.inflate(getLayoutInflater(), container, false);
        modelList = new ArrayList<>();
        intent = getActivity().getIntent();

        currentID = intent.getIntExtra("taskID",0);
        Log.i("TAG", "Inside VIEW Fragment, current Id is: "+ currentID);
        modelList = ToDoDatabase.getInstance(requireActivity()).getToDoDao().getToDoID(currentID);
        ToDoModel model = modelList.get(0);

        binding.todotitle.setText(model.getTitle());
        binding.tododiscription.setText(model.getDescription());
        binding.todolocation.setText(model.getLocation());
        binding.starttime.setText(model.getStartTime());
        binding.endtime.setText(model.getEndTime());
        binding.edtDate.setText(model.getDate());

//        *********** !!!!!!!!----Category section is not settled yet-----!!! *********

        binding.participateName.setText(model.getParticipant());

        taskPriority = model.getPriority();
        if (taskPriority.equals("High")){binding.priorityHigh.setChecked(true);}
        else if (taskPriority.equals("Medium")){binding.priorityMedium.setChecked(true);}
        else{binding.priorityLow.setChecked(true);}

        statusIsDone = model.isDone();
        if (statusIsDone){
            binding.todoStatus.setText("Done");}
        else{
            binding.todoStatus.setText("Not done");
        }

//        ---------------------------- Edit Actions -------------------------

        binding.todoStatus.setOnClickListener(view -> {
            if (statusIsDone){
                statusIsDone = false;
                binding.todoStatus.setText("Not Done");
            }
            else {
                statusIsDone = true;
                binding.todoStatus.setText("Done");
            }
        });

        binding.priorityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rBtn = getView().findViewById(i);
                taskPriority = rBtn.getText().toString();
            }
        });

//                 ---------------------------- Time and Date Start -----------------------------
        cal = Calendar.getInstance();

        //            ........... Start Time ..........
        binding.starttime.setOnClickListener(view -> {
            mHour = cal.get(Calendar.HOUR_OF_DAY);
            mMinute = cal.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            timePickerDialog = new TimePickerDialog(getActivity(),
                    (view12, hourOfDay, minute) -> {
                        binding.starttime.setText(StartTime(hourOfDay, minute));
                        timePickerDialog.dismiss();
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        });

        //            .......... End Time .........
        binding.endtime.setOnClickListener(view -> {
            mHour = cal.get(Calendar.HOUR_OF_DAY);
            mMinute = cal.get(Calendar.MINUTE);

            timePickerDialog = new TimePickerDialog(getActivity(),
                    (view12, hourOfDay, minute) -> {
                        binding.endtime.setText(StartTime(hourOfDay, minute));
                        timePickerDialog.dismiss();
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        });

//        ............. Data ...........
        binding.edtDate.setOnClickListener(view -> {
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    getActivity(),
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            binding.edtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    },
                    year, month, day);
            datePickerDialog.show();
        });

//                 ---------------------------- Time and Date End -----------------------------

        //        ---------------------------- Save Button Actions -------------------------
        binding.savebtn.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setIcon(R.drawable.priority_medium_icon);
            builder.setTitle("Save changes");
            builder.setMessage("Do you want to save this changes?");

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    ToDoModel toDoModel = new ToDoModel();
                    toDoModel.setId(currentID);

                    if (taskPriority.isEmpty()){taskPriority = "Low";}

                    if (binding.todotitle.getText().equals("")){binding.todotitle.setError("Field cannot be empty");}
                    else if (binding.tododiscription.getText().equals("")){binding.tododiscription.setError("Field cannot be empty");}
                    else if (binding.todolocation.getText().equals("")){binding.todolocation.setError("Field cannot be empty");}
                    else if (binding.starttime.getText().equals("")){binding.starttime.setError("Field cannot be empty");}
                    else if (binding.endtime.getText().equals("")){binding.endtime.setError("Field cannot be empty");}
                    else if (binding.participateName.getText().equals("")){binding.participateName.setError("Field cannot be empty");}
                    else{
                        toDoModel.setTitle(binding.todotitle.getText().toString());
                        toDoModel.setDescription(binding.tododiscription.getText().toString());
                        toDoModel.setLocation(binding.todolocation.getText().toString());
                        toDoModel.setStartTime(binding.starttime.getText().toString());
                        toDoModel.setEndTime(binding.endtime.getText().toString());
                        toDoModel.setDate(binding.edtDate.getText().toString());

                        toDoModel.setParticipant(binding.participateName.getText().toString());

                        // TODO: 11/27/2022  .... Category problem is not solved yet!
                        if (myCategories.equals("")){
//                            myCategories = "Personal";
                            myCategories = model.getCategories();
                        }
//                        else{
//                            //--------TODO: get data to the "myCategories"
//                            // myCategories = binding.getCategories.getText().toString();
//                        }

                        toDoModel.setCategories(myCategories);

                        toDoModel.setPriority(taskPriority);
                        toDoModel.setPinned(model.isPinned());
                        toDoModel.setDone(statusIsDone);
                        toDoModel.setTimeMillis(model.getTimeMillis());

                        ToDoDatabase.getInstance(getActivity()).getToDoDao().update(toDoModel);
                    }


                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        });



        return binding.getRoot();
    }


    private String StartTime(int hourOfDay, int minute) {
        Time tme = new Time(hourOfDay, minute, 0);//seconds by default set to zero
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        return formatter.format(tme);
    }
}