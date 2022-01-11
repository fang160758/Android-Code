package com.example.words;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class MyAdapter extends ListAdapter<Word,MyAdapter.MyViewHolder> {

    WordsViewModel wordsViewModel;


    MyAdapter(WordsViewModel wordsViewModel) {
        super(new DiffUtil.ItemCallback<Word>() {
            @Override
            public boolean areItemsTheSame(@NonNull @NotNull Word oldItem, @NonNull @NotNull Word newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull @NotNull Word oldItem, @NonNull @NotNull Word newItem) {
                return (oldItem.getChineseMeaning().equals(newItem.getChineseMeaning() )
                        && oldItem.getWord().equals(newItem.getWord())
                        && oldItem.isChineseRember() == newItem.isChineseRember());
            }
        });
        this.wordsViewModel = wordsViewModel;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.card,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + myViewHolder.textViewEnglish.getText());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                myViewHolder.itemView.getContext().startActivity(intent);
            }
        });

        myViewHolder.SwitchBar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Word word = (Word) myViewHolder.itemView.getTag(R.id.word_for_view_holder);
                if (isChecked) {
                    myViewHolder.textViewChinese.setVisibility(View.GONE);
                    word.setChineseRember(true);
                    wordsViewModel.updateWords(word);
                } else {
                    myViewHolder.textViewChinese.setVisibility(View.VISIBLE);
                    word.setChineseRember(false);
                    wordsViewModel.updateWords(word);
                }
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyAdapter.MyViewHolder holder, int position) {
        final Word word = getItem(position);
        holder.itemView.setTag(R.id.word_for_view_holder);
        holder.textViewNumber.setText(String.valueOf(position+1));
        holder.textViewChinese.setText(word.getChineseMeaning());
        holder.textViewEnglish.setText(word.getWord());

        if (word.isChineseRember()) {
            holder.textViewChinese.setVisibility(View.GONE);
            holder.SwitchBar.setChecked(true);
        } else {
            holder.textViewChinese.setVisibility(View.VISIBLE);
            holder.SwitchBar.setChecked(false);
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewEnglish,textViewChinese,textViewNumber;
        Switch SwitchBar;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewChinese = itemView.findViewById(R.id.textViewChinese);
            textViewEnglish = itemView.findViewById(R.id.textViewEnglish);
            textViewNumber = itemView.findViewById(R.id.textViewNumber);
            SwitchBar = itemView.findViewById(R.id.switchBar);
        }
    }
}
