package com.example.serializeabledemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.serializeabledemo.databinding.ActivityMainBinding;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;
    private static final String FILE_PATH = "myfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        binding.buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentData studentData = null;
                try {
                    inputStream = new ObjectInputStream(openFileInput(FILE_PATH));
                    studentData = (StudentData)inputStream.readObject();
                } catch (IOException e) {

                } catch (ClassNotFoundException e) {
                    Log.d("ss","sss");
                }
                binding.englishView.setText(String.valueOf(studentData.getScore().getEnglish()));
                binding.chineseView.setText(String.valueOf(studentData.getScore().getChinses()));
                binding.mathView.setText(String.valueOf(studentData.getScore().getMath()));
                binding.nameView.setText(studentData.getName());
                binding.idView.setText(String.valueOf(studentData.getId()));
            }
        });

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    outputStream = new ObjectOutputStream(openFileOutput(FILE_PATH,MODE_PRIVATE));
                    StudentData studentData = new StudentData(
                            binding.nameView.getText().toString(),
                            Integer.parseInt(binding.idView.getText().toString()),
                            new Score(
                                    Integer.parseInt(binding.englishView.getText().toString()),
                                    Integer.parseInt(binding.chineseView.getText().toString()),
                                    Integer.parseInt(binding.mathView.getText().toString())
                            )
                    );
                    outputStream.writeObject(studentData);
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {

                }
            }
        });



    }
}