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

public class ThridFragment extends Fragment {

    private ThridViewModel mViewModel;
    private ImageView imageView;

    public static ThridFragment newInstance() {
        return new ThridFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.thrid_fragment, container, false);
        imageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ThridViewModel.class);
        imageView.setRotation(mViewModel.rotation);
        // TODO: Use the ViewModel
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"rotation",0,0);
        objectAnimator.setDuration(500);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!objectAnimator.isRunning()) {
                    objectAnimator.setFloatValues(imageView.getRotation(),imageView.getRotation() + 100);
                    objectAnimator.start();
                    mViewModel.rotation = imageView.getRotation();
                }
            }
        });
    }

}