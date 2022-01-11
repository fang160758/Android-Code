package com.example.calcuationdemo3;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

@SuppressWarnings("ALL")
public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    private static final String KEY_LEFT_NUMBER = "key_left_number";
    private static final String KEY_RIGHT_NUMBER = "key_right_number";
    private static final String KEY_OPERATION = "key_operation";
    private static final String KEY_ANSWER = "key_answer";
    private static final String KEY_HIGHT_SCORE = "key_hight_score";
    private static final String KEY_SHP_NAME = "key_shp_name";
    private static final String KEY_SHP_DATA = "key_shp_data";
    private static String KEY_NOW_SCORE = "key_now_score";
    private static Boolean KEY_WIN_FLAG = false;
    public MyViewModel(@NonNull @NotNull Application application,SavedStateHandle handle) {
        super(application);

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(KEY_SHP_NAME, Context.MODE_PRIVATE);
        if (!handle.contains(KEY_SHP_DATA)) {
            handle.set(KEY_HIGHT_SCORE,sharedPreferences.getInt(KEY_SHP_DATA,0));
            handle.set(KEY_LEFT_NUMBER,0);
            handle.set(KEY_RIGHT_NUMBER,0);
            handle.set(KEY_OPERATION,"+");
            handle.set(KEY_ANSWER,0);
            handle.set(KEY_NOW_SCORE,0);
        }
        this.handle = handle;

    }

    public MutableLiveData<Integer> getLeftNumber() {
        return handle.getLiveData(KEY_LEFT_NUMBER);
    }

    public MutableLiveData<Integer> getRightNumber() {
        return handle.getLiveData(KEY_RIGHT_NUMBER);
    }

    public MutableLiveData<Integer> getAnswer() {
        return handle.getLiveData(KEY_ANSWER);
    }

    public MutableLiveData<String> getOperation() {
        return handle.getLiveData(KEY_OPERATION);
    }

    public MutableLiveData<Integer> getHihtScore() {
        return handle.getLiveData(KEY_HIGHT_SCORE);
    }

    public MutableLiveData<Integer> getNowScore() {
        return handle.getLiveData(KEY_NOW_SCORE);
    }

    public boolean getWinFlag() {
        return KEY_WIN_FLAG;
    }

    public void setKeyWinFlag(Boolean keyWinFlag) {
        KEY_WIN_FLAG = keyWinFlag;
    }

    public void genation() {
        int LEVEL = Integer.parseInt(getApplication().getResources().getString(R.string.level));
        Random random = new Random();
        int x = random.nextInt(LEVEL) + 1;
        int y = random.nextInt(LEVEL) + 1;
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        if (x % 2 == 0) {
            getOperation().setValue("+");
            getAnswer().setValue(x);
            getLeftNumber().setValue(x - y);
            getRightNumber().setValue(y);
        } else {
            getOperation().setValue("-");
            getAnswer().setValue(x - y);
            getLeftNumber().setValue(x);
            getRightNumber().setValue(y);
        }
    }

    public void save() {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(KEY_SHP_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_SHP_DATA,getHihtScore().getValue());
        editor.apply();
    }

    public void answerCorrect() {
        getNowScore().setValue(getNowScore().getValue() + 1);
        if (getNowScore().getValue() > getHihtScore().getValue()) {
            getHihtScore().setValue(getNowScore().getValue());
            save();
            KEY_WIN_FLAG = true;
        }
        genation();
    }
}
