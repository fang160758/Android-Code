package com.example.calcuationdemo3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calcuationdemo3.databinding.FragmentQuestionBinding;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ConstantConditions")
public class QuestionFragment extends Fragment {

    private static final String TAG = "kkkkkkkk";

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_question, container, false);
        MyViewModel myViewModel = new ViewModelProvider(requireActivity(),new SavedStateViewModelFactory(requireActivity().getApplication(),this)).get(MyViewModel.class);
        myViewModel.genation();
        myViewModel.getNowScore().setValue(0);
        FragmentQuestionBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);

        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        StringBuilder builder = new StringBuilder();

        View.OnClickListener listener = new  View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button17:
                        builder.append("0");
                        break;
                    case R.id.button6:
                        builder.append("1");
                        break;
                    case R.id.button7:
                        builder.append("2");
                        break;
                    case R.id.button8:
                        builder.append("3");
                        break;
                    case R.id.button9:
                        builder.append("4");
                        break;
                    case R.id.button10:
                        builder.append("5");
                        break;
                    case R.id.button11:
                        builder.append("6");
                        break;
                    case R.id.button12:
                        builder.append("7");
                        break;
                    case R.id.button13:
                        builder.append("8");
                        break;
                    case R.id.button14:
                        builder.append("9");
                        break;
                    case R.id.button15:
                        if (builder.length() != 0) {
                            builder.setLength(builder.length() - 1);
                        }
                        break;
                    default:
                        break;
                }
                binding.textView14.setText(builder.toString());
            }
        };

        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.button10.setOnClickListener(listener);
        binding.button11.setOnClickListener(listener);
        binding.button12.setOnClickListener(listener);
        binding.button13.setOnClickListener(listener);
        binding.button14.setOnClickListener(listener);
        binding.button17.setOnClickListener(listener);
        binding.button15.setOnClickListener(listener);

        binding.button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,builder.toString());
                if (builder.length() != 0) {
                    if (Integer.valueOf(builder.toString()).intValue() == myViewModel.getAnswer().getValue()) {
                        myViewModel.answerCorrect();
                        builder.setLength(0);
                        binding.textView14.setText(getString(R.string.answer_correct));
                    } else {
                        NavController controller = Navigation.findNavController(v);
                        if (myViewModel.getWinFlag()) {
                            controller.navigate(R.id.action_questionFragment_to_winFragment);
                            myViewModel.setKeyWinFlag(false);
                        } else {
                            controller.navigate(R.id.action_questionFragment_to_loseFragment);
                        }
                    }
                }
            }
        });
        return binding.getRoot();
    }
}