package com.codealpha.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class progress extends AppCompatActivity {
    final int MAX = 30, TOTAL = 300;
    ProgressBar total_prog;
    TextView progressText;
    private RecyclerView progress_view;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        progress_view=findViewById(R.id.activity_progress_recyclerView);
        total_prog = findViewById(R.id.total_progress);
        progressText = findViewById(R.id.t_progress_tv);

        ArrayList<progressData> list=new ArrayList<>();

        int[] prog = do_exc.progress;

        int t = 0;
        for (int i : prog) {
            t += i;
        }

        total_prog.setMax(TOTAL);
        total_prog.setProgress(t);

        int percentage = (int) ((float)t / TOTAL * 100);
        String s = percentage + "%";
        progressText.setText(s);


        list.add(new progressData(prog[0],"Air Squat"));
        list.add(new progressData(prog[1],"Bench Dips"));
        list.add(new progressData(prog[2],"Butterfly situp"));
        list.add(new progressData(prog[3],"Feat"));
        list.add(new progressData(prog[4],"Floor press"));
        list.add(new progressData(prog[5],"Forward lunge"));
        list.add(new progressData(prog[6],"Mountain climber"));
        list.add(new progressData(prog[7],"Pike press up"));
        list.add(new progressData(prog[8],"Pistol squat"));
        list.add(new progressData(prog[9],"Shoulder taps"));

        ProgressAdapter adapter =new ProgressAdapter(list);
        progress_view.setLayoutManager(new LinearLayoutManager(this));
        progress_view.setAdapter(adapter);

    }
}
