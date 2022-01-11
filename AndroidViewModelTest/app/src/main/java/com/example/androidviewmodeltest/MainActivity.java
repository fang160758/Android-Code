package com.example.androidviewmodeltest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProviders;

import com.example.androidviewmodeltest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this,new ())


    }

    @Override
    protected void onPause() {
        super.onPause();
        myViewModel.save();
    }
}