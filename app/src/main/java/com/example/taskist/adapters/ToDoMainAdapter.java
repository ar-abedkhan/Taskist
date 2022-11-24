package com.example.taskist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
