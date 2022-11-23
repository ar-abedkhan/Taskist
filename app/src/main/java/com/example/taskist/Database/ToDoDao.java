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


    @Query("SELECT * FROM ToDoModel WHERE id ==:todoID")
    List<ToDoModel> getToDoID(int todoID);

    @Query("SELECT * FROM ToDoModel")
    List<ToDoModel> getAllToDo();

    @Query("SELECT * FROM ToDoModel WHERE date ==:today")
    List<ToDoModel> getToDoToday(String today);

    @Query("SELECT * FROM ToDoModel WHERE isDone ==:isDone")
    List<ToDoModel> getToDoStatus(boolean isDone);

    @Query("SELECT * FROM ToDoModel WHERE isPinned ==:pinned")
    List<ToDoModel> getToDoPinned(boolean pinned);

    @Query("SELECT * FROM ToDoModel WHERE priority ==:priority")
    List<ToDoModel> getToDoByPriority(String priority);

    @Query("SELECT * FROM ToDoModel WHERE startTime ==:time")
    List<ToDoModel> getToDoByTime(String time);

}
