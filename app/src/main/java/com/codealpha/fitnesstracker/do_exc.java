package com.codealpha.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class do_exc extends AppCompatActivity {
    ProgressBar progressBar;
    ImageView imageView;
    Button pauseButton, continueButton;
    TextView countText;
    CountDownTimer countDownTimer;
    static int progress[] = new int[10];
    int index;
    long timeLeftMillis;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_exc);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.current_img);
        pauseButton = findViewById(R.id.btn_pause);
        continueButton = findViewById(R.id.btn_cont);
        countText = findViewById(R.id.count_text);

        progressBar.setProgress(30);
        progressBar.setMax(30);

        Intent intent = getIntent();
        index = intent.getIntExtra("id", 0);
        Exercise exercise = MyAdapter.exerciseList.get(index);
        imageView.setImageResource(exercise.getImageResource());

        setupCountDownTimer();

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resumeTimer();
            }
        });
    }

    private void setupCountDownTimer() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int secondsLeft = (int) (millisUntilFinished / 1000);
                countText.setText(String.valueOf(secondsLeft));
                progressBar.setProgress(secondsLeft, true);
            }

            @Override
            public void onFinish() {
                countText.setText("  ");
                Toast.makeText(getApplicationContext(), "Finished exercise", Toast.LENGTH_SHORT).show();
                progress[index] = 30;
                finish();
            }
        };
        countDownTimer.start();
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timeLeftMillis = Long.parseLong(countText.getText().toString()) * 1000;
    }

    private void resumeTimer() {
        countDownTimer = new CountDownTimer(timeLeftMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftMillis = millisUntilFinished;
                int secondsLeft = (int) (millisUntilFinished / 1000);
                countText.setText(String.valueOf(secondsLeft));
                progressBar.setProgress(secondsLeft, true);
            }

            @Override
            public void onFinish() {
                countText.setText("  ");
                Toast.makeText(getApplicationContext(), "Finished exercise", Toast.LENGTH_SHORT).show();
                finish();
            }
        };
        countDownTimer.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        progress[index] = 30 - Integer.parseInt(countText.getText().toString());
        countDownTimer.cancel();
    }
}
