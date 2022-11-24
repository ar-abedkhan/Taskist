package com.example.taskist.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//cannot create the entity here before, I just created entity for database.

@Database(entities = {ToDoModel.class}, version = 1)
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
