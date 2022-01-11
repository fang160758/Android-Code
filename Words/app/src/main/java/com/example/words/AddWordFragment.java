package com.example.words;

import android.content.Context;
import android.database.DatabaseUtils;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.words.databinding.FragmentAddBinding;

public class AddWordFragment extends Fragment {
    FragmentAddBinding binding;
    WordsViewModel wordsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        wordsViewModel = ViewModelProviders.of(requireActivity()).get(WordsViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false);
        binding.setLifecycleOwner(requireActivity());
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.editTextEnglishWord.requestFocus();
        binding.buttonSubmit.setEnabled(false);
        InputMethodManager inputMethodManager = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(binding.editTextEnglishWord, 0);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String englishText = binding.editTextEnglishWord.getText().toString().trim();
                String chineseText = binding.editTextTextShiYi.getText().toString().trim();

                if (!englishText.isEmpty() && !chineseText.isEmpty()) {
                    binding.buttonSubmit.setEnabled(true);
                } else {
                    binding.buttonSubmit.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        binding.editTextEnglishWord.addTextChangedListener(textWatcher);
        binding.editTextTextShiYi.addTextChangedListener(textWatcher);


        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String englishText = binding.editTextEnglishWord.getText().toString().trim();
                String chineseText = binding.editTextTextShiYi.getText().toString().trim();
                Word word = new Word(englishText,chineseText);
                wordsViewModel.insertWords(word);
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_addWordFragment_to_wordsListFragment);
            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        InputMethodManager inputMethodManager = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
    }
}