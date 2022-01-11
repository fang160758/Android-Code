package com.example.viewmodeltest;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    Button button1,button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        textView.setText(String.valueOf(myViewModel.number));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number++;
                textView.setText(String.valueOf(myViewModel.number));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number--;
                textView.setText(String.valueOf(myViewModel.number));
            }
        });
    }
}