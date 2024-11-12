package com.example.potholedectection.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.potholedectection.R;

import java.util.Timer;
import java.util.TimerTask;

public class Login_Activity extends AppCompatActivity {

    ImageView img_Google, img_Fb;
    Button btn_Signin, btn_Signup;
    ProgressBar progressBar;
    Timer timer;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_Signin = findViewById(R.id.btn_Signin);
        btn_Signup = findViewById(R.id.btn_Signup);
        img_Fb = findViewById(R.id.img_Fb);
        img_Google = findViewById(R.id.img_Google);
        progressBar = findViewById(R.id.progressBar);


        btn_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               setProgressBar();

                Intent intent = new Intent(Login_Activity.this, Sign_in_Activity.class);
                startActivity(intent);
            }
        });

        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setProgressBar();

                Intent intent2 = new Intent(Login_Activity.this, Sign_up_Activity.class);
                startActivity(intent2);
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