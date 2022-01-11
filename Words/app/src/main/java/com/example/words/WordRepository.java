package com.example.words;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> allWordLive;

    WordRepository(Context context) {
        WordDataBase wordDataBase = WordDataBase.getDatabase(context.getApplicationContext());
        wordDao = wordDataBase.getWordDao();
        allWordLive = wordDao.getAllWordsLive();
    }

    public void update(Word...words) {
        new UpdateAsyncTack(wordDao).execute(words);
    }

    public void delete(Word...words) {
        new deleteAsyncTack(wordDao).execute(words);
    }

    public void  inserts(Word...words) {
        new insertWordsAsyncTack(wordDao).execute(words);
    }

    public void deleteAll() {
        new deleteAllAsyncTack(wordDao).execute();
    }

    LiveData<List<Word>> getAllWordLive() {
        return allWordLive;
    }

    LiveData<List<Word>> findWordsWithPattern(String pattern) {
        return wordDao.findWordsWithPattern("%" + pattern + "%");
    }

    static class UpdateAsyncTack extends AsyncTask<Word,Void,Void> {
        WordDao wordDao;

        UpdateAsyncTack(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWords(words);
            return null;
        }
    }

    static class deleteAsyncTack extends AsyncTask<Word,Void,Void> {
        WordDao wordDao;
        deleteAsyncTack(WordDao wordDao) {
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords();
            return null;
        }
    }

    static class deleteAllAsyncTack extends AsyncTask<Void,Void,Void> {
        WordDao wordDao;
        deleteAllAsyncTack(WordDao wordDao) {
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;
        }
    }

    static class insertWordsAsyncTack extends AsyncTask<Word,Void,Void> {
        WordDao wordDao;
        insertWordsAsyncTack(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }
    }
}
