package com.example.parcelabel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.parcelabel.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        StudentData studentData = bundle.getParcelable("student");
        binding.editTextTextPersonName.setText(studentData.getName());
        binding.editTextTextPersonName2.setText(String.valueOf(studentData.getId()));
        binding.editTextTextPersonName3.setText(String.valueOf(studentData.getScore().getEnglish()));
        binding.editTextTextPersonName4.setText(String.valueOf(studentData.getScore().getChinses()));
        binding.editTextTextPersonName5.setText(String.valueOf(studentData.getScore().getMath()));

    }
}