package com.example.potholedectection.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.potholedectection.R;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class First_Activity extends AppCompatActivity {

    ProgressBar progressBar;
    View backgr;
    int count = 0;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        progressBar = findViewById(R.id.progressBar);
        backgr = findViewById(R.id.backgr);

        backgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setProgressBar();

                Intent intent = new Intent(First_Activity.this, Login_Activity.class);
                startActivity(intent);
            }
        });

    }



    private void setProgressBar() {

        progressBar.setVisibility(View.VISIBLE);

        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                count++;
                progressBar.setProgress(count);
                if(count == 100) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, 0, 100);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.GONE);
        }
    }
}