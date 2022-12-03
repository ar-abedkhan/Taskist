package com.example.taskist.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskist.Activitys.MainToDoActivity;
import com.example.taskist.Database.ToDoDatabase;
import com.example.taskist.Database.ToDoModel;
import com.example.taskist.R;
import com.example.taskist.databinding.FragmentViewBinding;

import java.util.ArrayList;
import java.util.List;

// --------------- Zeeshan ------

public class ViewFragment extends Fragment {

    public ViewFragment() {

    }

    List<ToDoModel> modelList;
    Intent intent;
    int currentID;
    FragmentViewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentViewBinding.inflate(getLayoutInflater(), container, false);

        modelList = new ArrayList<>();
        intent = getActivity().getIntent();

        currentID = intent.getIntExtra("taskID",0);
        Log.i("TAG", "Inside VIEW Fragment, current Id is: "+ currentID);
        modelList = ToDoDatabase.getInstance(requireActivity()).getToDoDao().getToDoID(currentID);
        ToDoModel model = modelList.get(0);

        binding.todotitle.setText(model.getTitle());
        binding.tododiscription.setText(model.getDescription());
        binding.todopriority.setText(model.getPriority());

        binding.viewCategories.setText(model.getCategories());

        binding.todolocation.setText(model.getLocation());
        binding.starttime.setText(model.getStartTime());
        binding.endtime.setText(model.getEndTime());
        binding.viewDate.setText(model.getDate());

        binding.participantName.setText(model.getParticipant());

        if (model.isDone()){
            binding.todoStatus.setText("Done");
        }else{ binding.todoStatus.setText("Not done");}

//        ------------------------- Deleting a task ---------------------------
        binding.deleteBtn.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setIcon(R.drawable.priority_high_icon);
            builder.setTitle("Delete");
            builder.setMessage("Do you really want to delete this item?\nYou won't be able to retrieve this data");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ToDoDatabase.getInstance(requireContext()).getToDoDao().delete(modelList.get(0));
                    Intent intent1 = new Intent(getActivity(), MainToDoActivity.class);
                    startActivity(intent1);
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        });


        return binding.getRoot();
    }

}