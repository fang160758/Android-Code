package com.example.navviewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.navviewmodel.databinding.FragmentDetaliBinding;


public class DetaliFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        FragmentDetaliBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detali,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_detaliFragment_to_homeFragment);
            }
        });
        return binding.getRoot();
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detali, container, false);
    }
}