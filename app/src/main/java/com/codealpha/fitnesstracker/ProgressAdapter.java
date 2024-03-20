package com.codealpha.fitnesstracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.Holder> {
    private List<progressData> list_data;

    public ProgressAdapter(List<progressData> list_data){
        this.list_data=list_data;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(parent.getContext());
        View v=li.inflate(R.layout.progress_list_view,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final progressData list=list_data.get(position);
        holder.exercise_bar.setMax(30);
        holder.exercise_bar.setProgress(list.getProgress());
        holder.name_text.setText(list.getName());
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

            TextView name_text;
            ProgressBar exercise_bar;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name_text=itemView.findViewById(R.id.progress_list_text);
            exercise_bar=itemView.findViewById(R.id.exercise_progress_bar);
        }
    }
}
