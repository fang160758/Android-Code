package com.example.words;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordsViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    public WordsViewModel(@NonNull @org.jetbrains.annotations.NotNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordLive();
    }

    LiveData<List<Word>> findWordsWithPattern(String patter) {
        return wordRepository.findWordsWithPattern(patter);
    }

    void insertWords(Word...words) {
        wordRepository.inserts(words);
    }

    void updateWords(Word...words) {
        wordRepository.update(words);
    }

    void deleteWords(Word...words) {
        wordRepository.delete(words);
    }

    void deleteAllWords() {
        wordRepository.deleteAll();
    }
}
