package com.codealpha.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class starter extends AppCompatActivity {
    CardView w,bmr,bmi,prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);

        w=findViewById(R.id.card_wo);
        bmr=findViewById(R.id.card_bmr);
        bmi=findViewById(R.id.card_bmi);
        prog=findViewById(R.id.card_progress);

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workout_intent=new Intent(starter.this, home.class);
                startActivity(workout_intent);
            }
        });

        bmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmrIntent=new Intent(starter.this, com.codealpha.fitnesstracker.bmr.class);
                startActivity(bmrIntent);
            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmi_intent=new Intent(starter.this, bmi.class);
                startActivity(bmi_intent);
            }
        });

        prog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(starter.this,progress.class);
                startActivity(i);
            }
        });
    }

}