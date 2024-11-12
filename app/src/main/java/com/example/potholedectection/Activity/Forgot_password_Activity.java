package com.example.potholedectection.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.potholedectection.R;

import java.util.Timer;
import java.util.TimerTask;

public class Forgot_password_Activity extends AppCompatActivity {

    ImageView btn_Back2;
    TextView txt_taiday;
    ProgressBar progressBar;
    Timer timer;
    int count;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btn_Back2 = findViewById(R.id.btn_Back2);
        txt_taiday = findViewById(R.id.txt_taiday);
        progressBar = findViewById(R.id.progressBar);

        btn_Back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        txt_taiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setProgressBar();
                Intent intent = new Intent(Forgot_password_Activity.this, Sign_up_Activity.class);
                startActivity(intent);
            }
        });
    }

    void setProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                count++;
                progressBar.setProgress(count);
                if(count == 30) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, 0, 30);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.GONE);
        }
    }
}