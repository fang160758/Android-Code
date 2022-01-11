package com.example.menuapp;

import androidx.lifecycle.ViewModelProvider;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FristFragment extends Fragment {

    private FristViewModel mViewModel;
    private ImageView imageView;

    public static FristFragment newInstance() {
        return new FristFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frist_fragment, container, false);
        imageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FristViewModel.class);
        // TODO: Use the ViewModel

        imageView.setScaleX(mViewModel.scaleX);
        imageView.setScaleY(mViewModel.scaleY);

        final ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageView,"scaleX",0,0);
        final ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageView,"scaleY",0,0);
        objectAnimatorX.setDuration(500);
        objectAnimatorY.setDuration(500);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!objectAnimatorX.isRunning()) {
                    objectAnimatorX.setFloatValues(imageView.getScaleX(),imageView.getScaleX() + 0.2f);
                    objectAnimatorY.setFloatValues(imageView.getScaleY(),imageView.getScaleY() + 0.2f);
                    objectAnimatorX.start();
                    objectAnimatorY.start();
                    mViewModel.scaleX += imageView.getScaleX();
                    mViewModel.scaleY += imageView.getScaleY();
                }
            }
        });
    }

}