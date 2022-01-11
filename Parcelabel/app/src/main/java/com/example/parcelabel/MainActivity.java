package com.example.parcelabel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.parcelabel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = binding.editTextTextPersonName.getText().toString();
                int Id = Integer.parseInt(binding.editTextTextPersonName2.getText().toString());
                int English = Integer.parseInt(binding.editTextTextPersonName3.getText().toString());
                int Chinese = Integer.parseInt(binding.editTextTextPersonName4.getText().toString());
                int Math = Integer.parseInt(binding.editTextTextPersonName5.getText().toString());
                StudentData studentData = new StudentData(Name,Id,new Score(English,Chinese,Math));

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                Bundle bundle = new Bundle();
                bundle.putParcelable("student",studentData);
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });

    }
}