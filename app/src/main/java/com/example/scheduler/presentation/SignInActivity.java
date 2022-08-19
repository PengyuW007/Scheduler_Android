package com.example.scheduler.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scheduler.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] status;
    private NumberPicker adminPicker;
    private TextView forget;
    private EditText name, password;
    private Button login;
    private String nameGet, passwordGet, statusGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        status = getResources().getStringArray(R.array.Admin);

        initUI();

        name.setOnClickListener(this);
        password.setOnClickListener(this);
        adminPicker.setOnClickListener(this);
        login.setOnClickListener(this);
        forget.setOnClickListener(this);
    }

    private void initUI() {
        /*** Edit Text ***/
        name = (EditText) findViewById(R.id.signIn_username_text);
        password = (EditText) findViewById(R.id.signIn_password_text);

        /*** Number Picker ***/
        adminPicker = findViewById(R.id.picker_status);
        adminPicker.setMinValue(0);
        adminPicker.setMaxValue(1);
        adminPicker.setDisplayedValues(status);

        /*** Login Button ***/
        login = findViewById(R.id.signIn_login_button);

        forget = findViewById(R.id.signIn_forget_text);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, StartScheduleActivity.class);

        if (view.getId() == R.id.signIn_login_button) {
            dataReceived(intent);
            startActivity(intent);
        }
    }

    private void dataReceived(Intent intent) {
        /*** Edit text ***/
        nameGet = name.getText().toString();
        passwordGet = password.getText().toString();
        Log.i("signIn_name_here",nameGet);
        Log.i("signIn_password_here",passwordGet);

        statusGet = status[adminPicker.getValue()];
        Log.i("signIn_status_here",statusGet);

        intent.putExtra("signIn_name_receive", nameGet);
        intent.putExtra("signIn_password_receive", passwordGet);
        intent.putExtra("signIn_status_receive", statusGet);
    }
}
