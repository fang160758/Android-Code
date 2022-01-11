package com.example.androidviewmodeltest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    private String shpName = getApplication().getResources().getString(R.string.shp_name);
    private String key = getApplication().getResources().getString(R.string.data_key);

    MyViewModel(@NonNull @org.jetbrains.annotations.NotNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!(handle.contains(key))) {
            load();
        }
    }

    public LiveData<Integer> getNuber() {
        return handle.getLiveData(key);
    }

    public void save() {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, getNuber().getValue() == null?0:getNuber().getValue());
        editor.apply();
    }

    private void load() {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        int x = sharedPreferences.getInt(key, 0);
        handle.set(key, x);
    }

    public void add(int n) {
        handle.set(key, getNuber().getValue() == null?0:getNuber().getValue() + n);
        save();
    }
}
