package com.example.calculationdemo;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Random;


@SuppressWarnings("SuspiciousNameCombination")
public class MyViewModel extends AndroidViewModel {
    SavedStateHandle handle;
    private static final String KEY_HIGH_SCORE = "key_hight_score";
    private static final String KEY_LEFT_NUMBER = "key_left_number";
    private static final String KEY_RIGHT_NUMBER = "key_right_number";
    private static final String KEY_OPERATOR = "key_operator";
    private static final String KEY_ANSWER = "key_answer";
    private static final String SAVE_SHP_DATA_NAME = "sava_shp_data_name";
    private static final String KEY_CURRENT_SCORE = "KEY_CURRENT_score";
    private static Boolean win_flag = false;

    public MyViewModel(@NonNull @org.jetbrains.annotations.NotNull Application application, SavedStateHandle handle) {
        super(application);
        if (!handle.contains(KEY_HIGH_SCORE)) {
            SharedPreferences sharedPreferences = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME, Context.MODE_PRIVATE);
            handle.set(KEY_HIGH_SCORE,sharedPreferences.getInt(KEY_HIGH_SCORE,0));
            handle.set(KEY_CURRENT_SCORE,0);
            handle.set(KEY_LEFT_NUMBER,0);
            handle.set(KEY_RIGHT_NUMBER,0);
            handle.set(KEY_OPERATOR,"+");
            handle.set(KEY_ANSWER,0);
        }
        this.handle = handle;
    }

    public MutableLiveData<Integer> getLeftNumber() {
        return handle.getLiveData(KEY_LEFT_NUMBER);
    }
    public MutableLiveData<Integer> getRightNumber() {
        return handle.getLiveData(KEY_CURRENT_SCORE);
    }

    public MutableLiveData<String> getOperator() {
        return handle.getLiveData(KEY_OPERATOR);
    }

    public MutableLiveData<Integer> getAnswer() {
        return handle.getLiveData(KEY_ANSWER);
    }

    public MutableLiveData<Integer> getHightScore() {
        return handle.getLiveData(KEY_HIGH_SCORE);
    }

    public MutableLiveData<Integer> getScore() {
        return handle.getLiveData(KEY_CURRENT_SCORE);
    }

    void generation() {
        int LEVE = 20;
        Random random = new Random();
        int x = random.nextInt(LEVE) + 1;
        int y = random.nextInt(LEVE) + 1;
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        if (x % 2 == 0) {
            getOperator().setValue("+");
            getAnswer().setValue(x);
            getRightNumber().setValue(y);
            getLeftNumber().setValue(x - y);

        }
        else {
            getOperator().setValue("-");
            getLeftNumber().setValue(x);
            getRightNumber().setValue(y);
            getAnswer().setValue(x - y);
        }
    }

    @SuppressWarnings("ConstantConditions")
    void save() {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME, Context.MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_HIGH_SCORE,getHightScore().getValue());
        editor.apply();
    }

    @SuppressWarnings("ConstantConditions")
    void answerCorrect() {
        getScore().setValue(getScore().getValue() + 1);
        if (getScore().getValue() > getHightScore().getValue()) {
            getHightScore().setValue(getScore().getValue());
            win_flag = true;
        }
    }
}
