package com.example.viewmodellivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> LikedNumber;

    public MutableLiveData<Integer> getLikedNumber() {
        if (LikedNumber == null) {
            LikedNumber = new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }

    public void addLikedNumber() {
        LikedNumber.setValue(LikedNumber.getValue() + 1);
    }
    public void subLikeNumber() {
        LikedNumber.setValue(LikedNumber.getValue() - 1);
    }
}
