package com.example.potholedectection.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.potholedectection.R;

import java.util.Timer;
import java.util.TimerTask;

public class Sign_up_Activity extends AppCompatActivity {

    ImageView btn_Back3;
    TextView signin_new;
    ProgressBar progressBar;
    Timer timer;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_Back3 = findViewById(R.id.btn_Back3);
        signin_new =  findViewById(R.id.signin_new);
        progressBar = findViewById(R.id.progressBar);

        btn_Back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signin_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setProgressBar();

                Intent intent = new Intent(Sign_up_Activity.this, Sign_in_Activity.class);
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