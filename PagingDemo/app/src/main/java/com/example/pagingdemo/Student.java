package com.example.pagingdemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "student_name")
    private String studentName;
}
