package com.example.pagingdemo;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
    static StudentDataBase instance;

    static synchronized StudentDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,StudentDataBase.class,"student_database").build();
        }
        return instance;
    }

    abstract StudentDao getStudentDao();
}
