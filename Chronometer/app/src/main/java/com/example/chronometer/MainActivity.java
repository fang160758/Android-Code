package com.example.chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    NyChronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.meter);
        getLifecycle().addObserver(chronometer);
    }
}