package com.example.navviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    public MutableLiveData<Integer> LiveNumber;

    public MutableLiveData<Integer> getLiveNumber() {
        if (LiveNumber == null) {
            LiveNumber = new MutableLiveData<>();
            LiveNumber.setValue(0);
        }
        return LiveNumber;
    }


    public void add(int n) {
        getLiveNumber().setValue(getLiveNumber().getValue() == null ? 0 : getLiveNumber().getValue() + n);
    }
}
