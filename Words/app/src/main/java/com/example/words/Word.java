package com.example.words;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "english_word")
    private String word;

    @ColumnInfo(name = "chinese_meaning")
    private String chineseMeaning;

    @ColumnInfo(name = "is_chinese_rember")
    private boolean chineseRember;


    public Word(String word,String chineseMeaning){
        this.word = word;
        this.chineseMeaning = chineseMeaning;
        this.chineseRember = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChineseMeaning(String chineseMeaning) {
        this.chineseMeaning = chineseMeaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChineseMeaning() {
        return chineseMeaning;
    }

    public boolean isChineseRember() {
        return chineseRember;
    }

    public void setChineseRember(boolean chineseRember) {
        this.chineseRember = chineseRember;
    }
}
