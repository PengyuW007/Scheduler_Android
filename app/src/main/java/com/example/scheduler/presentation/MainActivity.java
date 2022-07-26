package com.example.scheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.scheduler.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
    }

    private void initializeUI() {
        // Button reactions //
        findViewById(R.id.start_button).setOnClickListener(this);
        findViewById(R.id.signIn_button).setOnClickListener(this);
    }//end initializeUI

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        if(view.getId()==R.id.start_button){
            intent.setClass(getApplicationContext(),StartScheduleActivity.class);
        }else if(view.getId()==R.id.signIn_button){
            intent.setClass(getApplicationContext(), SignInActivity.class);
        }
        startActivity(intent);
    }
}