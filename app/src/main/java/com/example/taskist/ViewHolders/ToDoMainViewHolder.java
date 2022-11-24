package com.example.taskist.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskist.R;

public class ToDoMainViewHolder extends RecyclerView.ViewHolder {

    Switch status;
    ImageView priorityImg, editTodoImg;
    TextView title, categories, startTime, endTime, location, participant;

    public ToDoMainViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.todoTitle);
        categories = itemView.findViewById(R.id.todoCategories);
        location = itemView.findViewById(R.id.todolocation);
        startTime = itemView.findViewById(R.id.starttime);
        endTime = itemView.findViewById(R.id.endingtime);
        participant = itemView.findViewById(R.id.todoParticipants);


        status = itemView.findViewById(R.id.todoStatus);
        priorityImg = itemView.findViewById(R.id.todoPriority);
        editTodoImg = itemView.findViewById(R.id.edittodo);
    }
}
