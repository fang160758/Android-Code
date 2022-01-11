package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class MyData {
    public int number;
    private Context context;
    public MyData(Context context) {
        this.context = context;
    }

    public void save(int number) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_data1",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("NUMBER",number);
        editor.apply();
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
