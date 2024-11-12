package com.example.potholedectection.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.potholedectection.R;

import java.util.Timer;
import java.util.TimerTask;

public class Sign_in_Activity extends AppCompatActivity {

    EditText edt_Email, edt_Password;
    CheckBox remember;
    TextView txt_Forgot, txt_Signup_new;
    Button btn_Signin2;
    ImageView img_Google, img_Fb, btn_Back;
    ProgressBar progressBar;
    Timer timer;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_Back = findViewById(R.id.btn_Back);
        btn_Signin2 = findViewById(R.id.btn_Signin2);
        edt_Password = findViewById(R.id.edt_Password);
        edt_Email = findViewById(R.id.edt_Email);
        remember = findViewById(R.id.remember);
        txt_Forgot = findViewById(R.id.txt_Forgot);
        txt_Signup_new = findViewById(R.id.txt_Signup_new);
        img_Fb = findViewById(R.id.img_Fb);
        img_Google = findViewById(R.id.img_Google);
        progressBar = findViewById(R.id.progressBar);

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txt_Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setProgressBar();

                Intent intent = new Intent(Sign_in_Activity.this, Forgot_password_Activity.class );
                startActivity(intent);
            }
        });

        txt_Signup_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setProgressBar();

                Intent intent = new Intent(Sign_in_Activity.this, Sign_up_Activity.class );
                startActivity(intent);
            }
        });

        btn_Signin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Sign_in_Activity.this, MainActivity.class);
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