package com.example.words;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.words.databinding.FragmentWordsListBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WordsListFragment extends Fragment {
    LiveData<List<Word>> filteredWords;
    FragmentWordsListBinding binding;
    RecyclerView recyclerView;
    WordsViewModel wordsViewModel;
    MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_words_list,container,false);
        Log.d("mydata","onCreateView");
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("mydata", "onActivityCreated: ");
        wordsViewModel = ViewModelProviders.of(requireActivity()).get(WordsViewModel.class);
        recyclerView = requireActivity().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        myAdapter = new MyAdapter(wordsViewModel);
        recyclerView.setItemAnimator(new DefaultItemAnimator() {
            @Override
            public void onAnimationFinished(@NonNull @NotNull RecyclerView.ViewHolder viewHolder) {
                super.onAnimationFinished(viewHolder);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager != null) {
                    int firstPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    int lastPosition = linearLayoutManager.findLastVisibleItemPosition();
                    for (int i = firstPosition; i <= lastPosition; i++) {
                        MyAdapter.MyViewHolder myViewHolder = (MyAdapter.MyViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
                        if (myViewHolder != null) {
                            myViewHolder.textViewNumber.setText(String.valueOf(i + 1));
                        }
                    }
                }
            }
        });
        recyclerView.setAdapter(myAdapter);
        filteredWords = wordsViewModel.getAllWordsLive();
        filteredWords.observe(getViewLifecycleOwner(), new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                int temp = myAdapter.getItemCount();
                if (temp != words.size()) {
                    if (temp < words.size()) {
                        recyclerView.smoothScrollBy(0,-200);
                    }
                    myAdapter.submitList(words);
                }
            }
        });
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_wordsListFragment_to_addWordFragment);
            }
        });
    }
}