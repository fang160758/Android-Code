package com.example.chronometer;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private static final String TAG = "DEBUGllll";
    MutableLiveData<Long> elapsedTime;
    public MutableLiveData<Long> getElapsedTime() {
        if (elapsedTime == null) {
            elapsedTime = new MutableLiveData<>();
            elapsedTime.setValue((long) 0);
            Log.d(TAG, "getElapsedTime: ");
        }
        return elapsedTime;
    }
}
