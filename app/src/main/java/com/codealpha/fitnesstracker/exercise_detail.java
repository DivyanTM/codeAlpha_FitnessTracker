package com.codealpha.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class exercise_detail extends AppCompatActivity {
    ImageView back;
    TextView title,desc;
    ImageView ex;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        title=findViewById(R.id.detail_top_title);
        desc=findViewById(R.id.detail_description);
        ex=findViewById(R.id.detail_image);
        start=findViewById(R.id.detail_start_btn);

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        int id=R.drawable.air_squat;
        Intent detailIntent=getIntent();
        if(detailIntent!=null){
            String s=detailIntent.getStringExtra("position");
           int position=Integer.parseInt(s);
            Exercise exercise=MyAdapter.exerciseList.get(position);
            title.setText(exercise.getName());
            ex.setImageResource(exercise.getImageResource());
            id=position;
            desc.setText(exercise.getProcd());
        }
        int finalId =id;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doInt=new Intent(exercise_detail.this, do_exc.class);
                doInt.putExtra("id", finalId);
                startActivity(doInt);
            }
        });
    }
}