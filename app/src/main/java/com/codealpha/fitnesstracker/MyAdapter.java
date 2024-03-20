package com.codealpha.fitnesstracker;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
   static List<Exercise> exerciseList;
   Context context;
    public MyAdapter(Context context,List<Exercise> list_data) {
        MyAdapter.exerciseList = list_data;
        this.context=context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View list_item = li.inflate(R.layout.ex_list, parent, false);
        return new Holder(list_item);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        final Exercise exercise = exerciseList.get(position);
        holder.name.setText(exercise.getName());
        holder.image.setImageResource(exercise.getImageResource());
        holder.r_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent=new Intent(context, exercise_detail.class);
                detailIntent.putExtra("position",Integer.toString(position));
                context.startActivity(detailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        LinearLayout r_area;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.list_name);
            image = itemView.findViewById(R.id.list_image);
            r_area=itemView.findViewById(R.id.responsive_area);
        }
    }
}
