package com.example.pagingdemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertdata(Student...students);

    @Query("DELETE FROM STUDENT_TABLE ")
    void deleteAlldata();

    @Query("SELECT * FROM STUDENT_TABLE ORDER BY ID DESC")
    LiveData<List<Student>> getAllData();
}
