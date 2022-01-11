package com.example.menuapp;

import androidx.lifecycle.ViewModelProvider;

import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

public class SecFragment extends Fragment {

    private SecViewModel mViewModel;
    private ImageView imageView;

    public static SecFragment newInstance() {
        return new SecFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.sec_fragment, container, false);
        imageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SecViewModel.class);
        // TODO: Use the ViewModel

        imageView.setX(mViewModel.x);

        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"x",0,0);
        objectAnimator.setDuration(500);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!objectAnimator.isRunning()) {
                    float dx = new Random().nextBoolean() ? 100: -100;
                    objectAnimator.setFloatValues(imageView.getX(),imageView.getX() + dx);
                    objectAnimator.start();
                    mViewModel.x += dx;

                }
            }
        });
    }

}