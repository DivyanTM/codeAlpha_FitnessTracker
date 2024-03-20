package com.codealpha.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class bmr extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] genders = {"Male", "Female"};

    TextView bmrTxt, desc;
    ImageView back;
    Button calculate;
    EditText h, w, a;
    Spinner gen;
    CardView bmrCard;
    int gender = 1;
    double bmr;
    double height, weight;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        bmrCard = findViewById(R.id.bmr_card);
        desc = findViewById(R.id.bmr_desc);
        back = findViewById(R.id.app_bar_back);
        calculate = findViewById(R.id.bmr_calculate_btn);
        h = findViewById(R.id.bmr_height);
        w = findViewById(R.id.bmr_weight);
        a = findViewById(R.id.bmr_age);
        gen = findViewById(R.id.bmr_gender);

        gen.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gen.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    age = Integer.parseInt(a.getText().toString());
                    height = Double.parseDouble(h.getText().toString());
                    weight = Double.parseDouble(w.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(bmr.this, "Please enter valid values for age, height, and weight.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (gender == 1) {
                    bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
                } else {
                    bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
                }
                desc.setText(String.format("%.2f", bmr));
                bmrCard.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            gender = 1;
        } else {
            gender = 2;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
