package com.example.taskist.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskist.Database.ToDoDatabase;
import com.example.taskist.Database.ToDoModel;
import com.example.taskist.R;
import com.example.taskist.databinding.FragmentEditBinding;

import java.util.ArrayList;
import java.util.List;

public class EditFragment extends Fragment {


    public EditFragment() {

    }
//    ---------- @Zeeshan


    FragmentEditBinding binding;
    Intent intent;
    List<ToDoModel> modelList;
    int currentID;
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

//        *********** !!!!!!!!----Category section is not settled yet-----!!! *********

        binding.participateName.setText(model.getParticipant());

        if (model.getPriority().equals("High")){binding.priorityHigh.setChecked(true);}
        else if (model.getPriority().equals("Medium")){binding.priorityMedium.setChecked(true);}
        else{binding.priorityLow.setChecked(true);}

        if (model.isDone()){
            binding.todoStatus.setText("Done");}
        else{
            binding.todoStatus.setText("Not done");}


        return binding.getRoot();
    }
}