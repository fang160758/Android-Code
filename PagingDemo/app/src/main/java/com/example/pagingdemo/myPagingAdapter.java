package com.example.pagingdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class myPagingAdapter extends PagedListAdapter<Student,myPagingAdapter.MyViewHolder> {


    protected myPagingAdapter() {
        super(new DiffUtil.ItemCallback<Student>() {
            @Override
            public boolean areItemsTheSame(@NonNull @NotNull Student oldItem, @NonNull @NotNull Student newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull @NotNull Student oldItem, @NonNull @NotNull Student newItem) {
                return oldItem.getStudentNum() == newItem.getStudentNum();
            }
        });
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cell,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Student student = getItem(position);
        if (student == null) {
            holder.textViewShow.setText("Loging.....");
        } else {
            holder.textViewShow.setText(String.valueOf(student.getStudentNum()));
        }
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewShow;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewShow = itemView.findViewById(R.id.textViewShow);
        }
    }

}
