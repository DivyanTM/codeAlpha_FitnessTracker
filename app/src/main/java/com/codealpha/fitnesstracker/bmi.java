package com.codealpha.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.Format;

public class bmi extends AppCompatActivity {
    LinearLayout ll;
    CardView cd;
    TextView bmi_txt;
    TextView desc;
    Button calc;
    EditText h, w;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        ll = findViewById(R.id.bmi_ll);
        cd = findViewById(R.id.bmi_card);
        bmi_txt = findViewById(R.id.bmi_txt);
        desc = findViewById(R.id.bmi_desc);
        calc = findViewById(R.id.calculate_btn);
        h = findViewById(R.id.height);
        w = findViewById(R.id.weight);
        back = findViewById(R.id.app_bar_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (h.getText().toString().isEmpty() || w.getText().toString().isEmpty()) {
                    return;
                }

                double height = Double.parseDouble(h.getText().toString()) / 100;
                double weight = Double.parseDouble(w.getText().toString());
                double bmi = weight / (height * height);

                String bmiCategory;
                int backgroundColor;

                if (bmi < 18.5) {
                    bmiCategory = "Underweight";
                    backgroundColor = R.color.yellow;
                } else if (bmi < 25) {
                    bmiCategory = "Normal weight";
                    backgroundColor = R.color.green;
                } else if (bmi < 30) {
                    bmiCategory = "Overweight";
                    backgroundColor = R.color.orange;
                } else {
                    bmiCategory = "Obese";
                    backgroundColor = R.color.red;
                }


                ll.setBackgroundColor(getResources().getColor(backgroundColor));
                desc.setText(bmiCategory);


                bmi_txt.setText(String.format("%.2f", bmi));


                cd.setVisibility(View.VISIBLE);
            }
        });
    }
}
