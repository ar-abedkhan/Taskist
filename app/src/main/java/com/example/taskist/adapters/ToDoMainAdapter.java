package com.example.taskist.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskist.Activitys.TodoView;
import com.example.taskist.Database.ToDoDatabase;
import com.example.taskist.Database.ToDoModel;
import com.example.taskist.Listeners.ToDoMainListener;
import com.example.taskist.R;
import com.example.taskist.ViewHolders.ToDoMainViewHolder;

import java.util.List;

public class ToDoMainAdapter extends RecyclerView.Adapter<ToDoMainViewHolder> {
    Context context;
    List<ToDoModel> toDoList;
    ToDoMainListener listener;

    public ToDoMainAdapter(Context context, List<ToDoModel> toDoList, ToDoMainListener listener) {
        this.context = context;
        this.toDoList = toDoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ToDoMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.todorecycler, parent, false);
        return new ToDoMainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoMainViewHolder holder, int position) {
        ToDoModel model = toDoList.get(position);

        holder.title.setText(model.getTitle());
        if (model.getCategories().trim().endsWith(",")){

            String myCategories = model.getCategories().replace(","," ");
            holder.categories.setText(myCategories);
        }

        holder.participant.setText(model.getParticipant());
        holder.location.setText(model.getLocation());
        holder.startTime.setText(model.getStartTime());
        holder.endTime.setText(model.getEndTime());
        holder.status.setChecked(model.isDone());

        if (model.getPriority().equals("High"))
        {holder.priorityImg.setImageResource(R.drawable.priority_high_icon);}
        if (model.getPriority().equals("Medium"))
        {holder.priorityImg.setImageResource(R.drawable.priority_medium_icon);}
        if(model.getPriority().equals("Low"))
        {holder.priorityImg.setImageResource(R.drawable.priority_normal_icon);}

        if (model.isDone()){
            holder.statusTxt.setText("Done");
        }else {
            holder.statusTxt.setText("Undone");
        }

//        --------------- Handling TO-DO Status -----------------
        holder.status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    holder.statusTxt.setText("Done");
                }else {
                    holder.statusTxt.setText("Undone");
                }
                model.setDone(b);
                ToDoDatabase.getInstance(context).getToDoDao().update(model);
                listener.screenRefresher();
            }
        });

        holder.editTodoImg.setOnClickListener(view -> {
            Intent intent = new Intent(context, TodoView.class);
            intent.putExtra("taskID", model.getId());
            context.startActivity(intent);
        });

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, TodoView.class);
            intent.putExtra("taskID", model.getId());
            context.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
