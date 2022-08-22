package com.example.scheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.scheduler.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String dbName = "Scheduler";
    private static String dbPath = "database/Scheduler";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
    }

    private void initializeUI() {
        // Button reactions //
        findViewById(R.id.register_button).setOnClickListener(this);
        findViewById(R.id.signIn_button).setOnClickListener(this);
    }//end initializeUI

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        if (view.getId() == R.id.register_button) {
            intent.setClass(getApplicationContext(), RegisterActivity.class);
        } else if (view.getId() == R.id.signIn_button) {
            intent.setClass(getApplicationContext(), SignInActivity.class);
        }
        startActivity(intent);
    }

    public static void setDBPathName(String pathName) {
        //actually,set dbPath
        dbPath = pathName;
    }

    public static String getDBPathName() {
        //actually,get dbPath
        String res = "";
        if (dbPath != null) {
            res = dbPath;
        } else {
            res = dbName;
        }
        return res;
    }
}