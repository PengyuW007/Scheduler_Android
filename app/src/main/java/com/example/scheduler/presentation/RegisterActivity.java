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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] sections;
    private NumberPicker sectionsPicker;
    private TextView section;
    private EditText name, password;
    private Button confirm;
    private String nameGet, passwordGet,sectionGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sections = getResources().getStringArray(R.array.sections);

        initUI();

        findViewById(R.id.signUp_username_text).setOnClickListener(this);
        findViewById(R.id.signUp_password_text).setOnClickListener(this);
        findViewById(R.id.signUp_login_button).setOnClickListener(this);
    }

    private void initUI() {
        /*** Edit Text ***/
        name = (EditText) findViewById(R.id.signUp_username_text);
        password = (EditText) findViewById(R.id.signUp_password_text);
        /*** Number picker ***/
        section = findViewById(R.id.text_section_picker);
        sectionsPicker = (NumberPicker) findViewById(R.id.number_picker_sections);
        sectionsPicker.setMinValue(0);
        sectionsPicker.setMaxValue(6);
        sectionsPicker.setDisplayedValues(sections);

        /*** Confirm button ***/
        confirm = findViewById(R.id.signUp_login_button);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        if(view.getId()==R.id.signUp_login_button){
            dataReceived(intent);
            startActivity(intent);
        }
    }

    private void dataReceived(Intent intent) {
        /*** Edit text ***/
        nameGet = name.getText().toString();
        passwordGet = password.getText().toString();
        Log.i("name_here",nameGet);
        Log.i("password_here",passwordGet);

        sectionGet =sections[sectionsPicker.getValue()];
        Log.i("section_here",sectionGet);

        intent.putExtra("name_receive",nameGet);
        intent.putExtra("password_receive",passwordGet);
        intent.putExtra("section_receive",sectionGet);
    }
}
