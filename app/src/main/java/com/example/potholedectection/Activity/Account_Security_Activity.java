package com.example.potholedectection.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potholedectection.R;

public class Account_Security_Activity extends AppCompatActivity {

    TextView myprofile;
    ImageView btn_Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);

        myprofile = findViewById(R.id.myprofile);
        btn_Back = findViewById(R.id.btn_Back);

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Account_Security_Activity.this, Edit_Account_Activity.class);
                startActivity(intent);
            }
        });

    }
}