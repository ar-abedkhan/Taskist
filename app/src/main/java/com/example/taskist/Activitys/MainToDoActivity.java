package com.example.taskist.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.taskist.Database.ToDoDatabase;
import com.example.taskist.Database.ToDoModel;
import com.example.taskist.Listeners.ToDoMainListener;
import com.example.taskist.R;
import com.example.taskist.adapters.ToDoMainAdapter;
import com.example.taskist.databinding.ActivityMainToDoBinding;

import java.util.List;

public class MainToDoActivity extends AppCompatActivity implements ToDoMainListener {

    ActivityMainToDoBinding binding;
    List<ToDoModel> toDoModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainToDoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setDataToAdapter();

//---------------------------- ALl Buttons Actions --------------------------
//        binding.backBtn.setOnClickListener(view -> {
//            startActivity(new Intent(MainToDoActivity.this, MainActivity.class));
//            finish();
//        });

        binding.addBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainToDoActivity.this, ToDoAddActivity.class));
            finish();
        });

        binding.bottomMenu.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.bottomHome:
                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.bottomAll:
                    startActivity(new Intent(MainToDoActivity.this, AllListActivity.class));
                    finish();
                    break;
            }
            return true;
        });
//       set the heading here
        nextimptask();

    }

    private void nextimptask() {
        toDoModelList = ToDoDatabase.getInstance(this).getToDoDao().getAllToDo();
        if(toDoModelList.size()==0){
            binding.impTaskTitle.setText("You don't have any task" );
            binding.impTaskCategory.setText(" ");
            binding.impTaskStartTime.setText(" ");
            binding.impTaskEndTime.setText(" ");
            binding.impTaskPriority.setText(" ");
        }
        else {
            binding.impTaskTitle.setText(toDoModelList.get(0).getTitle());
            binding.impTaskCategory.setText(toDoModelList.get(0).getCategories());
            binding.impTaskStartTime.setText(toDoModelList.get(0).getStartTime());
            binding.impTaskEndTime.setText(toDoModelList.get(0).getEndTime());
            binding.impTaskPriority.setText(toDoModelList.get(0).getPriority());
        }

    }

    //    ---------------- setDataToAdapter is mainly created to set data to the adapter -------------
    private void setDataToAdapter() {
        ToDoMainAdapter adapter = new ToDoMainAdapter(this, ToDoDatabase.getInstance(this).getToDoDao().getAllToDo(), MainToDoActivity.this);
        binding.countText.setText("Today you have " +adapter.getItemCount()+" task to do ");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.todayTaskRecycler.setLayoutManager(linearLayoutManager);
        binding.todayTaskRecycler.setAdapter(adapter);
    }

    @Override
    public void screenRefresher() {

    }
}