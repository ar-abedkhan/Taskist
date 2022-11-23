package com.example.taskist.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ToDoDataModel {

    @PrimaryKey (autoGenerate = true)
    int id;

    @ColumnInfo
    private String title, description, startTime, endTime, date, participant, location, priority, categories;

    @ColumnInfo
    private boolean isDone;

    @ColumnInfo
    private long timeMillis;
}
