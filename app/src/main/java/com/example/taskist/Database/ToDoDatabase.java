package com.example.taskist.Database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class ToDoDatabase extends RoomDatabase {
    public abstract ToDoDao getToDoDao();
    static ToDoDatabase toDoDatabase = null;

    public static ToDoDatabase getInstance(Context context) {
        if (toDoDatabase == null){
            toDoDatabase = Room.databaseBuilder(context,
                    ToDoDatabase.class,
                    "ToDoDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return toDoDatabase;
    }
}
