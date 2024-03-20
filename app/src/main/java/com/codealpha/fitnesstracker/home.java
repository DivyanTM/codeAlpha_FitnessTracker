package com.codealpha.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Exercise> list_data;
    ImageView back,b_act;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        list_data=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        back=findViewById(R.id.app_bar_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Description d=new Description();

        list_data.add(new Exercise(R.drawable.air_squat,"Air Squat",d.desc.get(0)));
        list_data.add(new Exercise(R.drawable.bench_dips,"Bench Dips",d.desc.get(1)));
        list_data.add(new Exercise(R.drawable.butterfly_situp,"Butterfly situp",d.desc.get(2)));
        list_data.add(new Exercise(R.drawable.feat,"Feat",d.desc.get(3)));
        list_data.add(new Exercise(R.drawable.floor_press,"Floor press",d.desc.get(4)));
        list_data.add(new Exercise(R.drawable.forward_lunge,"Forward Lunge",d.desc.get(5)));
        list_data.add(new Exercise(R.drawable.mountain_climber,"Mountain climber",d.desc.get(6)));
        list_data.add(new Exercise(R.drawable.pike_press_up,"Pike press up",d.desc.get(7)));
        list_data.add(new Exercise(R.drawable.pistol_squat,"Pistol squat",d.desc.get(8)));
        list_data.add(new Exercise(R.drawable.shoulder_taps,"Shoulder taps",d.desc.get(9)));
        MyAdapter adapter=new MyAdapter(this,list_data);
        recyclerView.setAdapter(adapter);


    }
}
