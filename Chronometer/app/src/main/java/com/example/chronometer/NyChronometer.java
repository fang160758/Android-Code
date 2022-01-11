package com.example.chronometer;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.androidx.lifecycle.ViewModelProviders;

public class NyChronometer extends Chronometer implements LifecycleObserver {
    private long elapsedTime;

    public NyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter() {
//        myViewModel.getElapsedTime().setValue(SystemClock.elapsedRealtime() - getBase());
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
    }

    @SuppressWarnings("ConstantConditions")
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter() {
//        setBase(SystemClock.elapsedRealtime() - myViewModel.getElapsedTime().getValue());
        setBase(SystemClock.elapsedRealtime() - elapsedTime);
        start();
    }
}
