package com.example.potholedectection.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.potholedectection.R;

public class Setting_Activity extends AppCompatActivity {

    TextView infor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        infor = findViewById(R.id.infor);
        infor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Setting_Activity.this, Account_Security_Activity.class);
                startActivity(intent);
            }
        });
    }
}