package com.example.calcuationdemo3;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calcuationdemo3.databinding.FragmentTitleBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TitleFragment extends Fragment {

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_title, container, false);
        MyViewModel myViewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(requireActivity().getApplication(), this)).get(MyViewModel.class);
        FragmentTitleBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_titleFragment_to_questionFragment);
            }
        });
        return binding.getRoot();
    }
}