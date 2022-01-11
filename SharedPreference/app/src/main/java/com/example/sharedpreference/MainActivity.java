package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyData data = new MyData(getApplicationContext());
        data.save(100);

        int n = data.getNumber();
        String TAG = "mydata1";
        Log.d(TAG, "mydata1 " + n);

//        SharedPreferences sharedPreferences= getSharedPreferences("my_data", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("NUMBER",100);
//        editor.apply();
//
//        int key = sharedPreferences.getInt("NUMBER",0);
//        final String TAG = "mydata";
//        Log.d(TAG, "mydata: " + key);
    }
}