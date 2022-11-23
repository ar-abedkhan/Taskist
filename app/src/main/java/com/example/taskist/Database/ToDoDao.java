package com.example.taskist.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ToDoDao {
    @Insert
    void insert(ToDoModel todoModel);

    @Update
    void update(ToDoModel toDoModel);

    @Delete
    void delete(ToDoModel toDoModel);

    @Query("SELECT * FROM ToDoModel")
    List<ToDoModel> getAllToDo();
}
