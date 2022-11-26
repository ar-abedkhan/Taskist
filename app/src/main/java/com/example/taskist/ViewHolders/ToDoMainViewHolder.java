package com.example.taskist.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskist.R;

public class ToDoMainViewHolder extends RecyclerView.ViewHolder {

    public Switch status;
    public ImageView priorityImg, editTodoImg;
    public TextView title, categories, startTime, endTime, location, participant,startdate, enddate;

    public ToDoMainViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.todoTitle);
        categories = itemView.findViewById(R.id.todoCategories);
        location = itemView.findViewById(R.id.todolocation);
        startTime = itemView.findViewById(R.id.starttime);
        endTime = itemView.findViewById(R.id.endingtime);

        startdate = itemView.findViewById(R.id.addDate);
        participant = itemView.findViewById(R.id.todoParticipants);

        status = itemView.findViewById(R.id.todoStatus);
        priorityImg = itemView.findViewById(R.id.todoPriorityimg);
        editTodoImg = itemView.findViewById(R.id.edittodo);
    }
}
