package com.example.scheduler.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scheduler.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private String[]sections;
    private NumberPicker sectionsPicker;
    private TextView section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sections = getResources().getStringArray(R.array.sections);
        initUI();
    }

    private void initUI(){
        section = findViewById(R.id.text_section_picker);
        sectionsPicker = (NumberPicker) findViewById(R.id.number_picker_sections);
        sectionsPicker.setMinValue(0);
        sectionsPicker.setMaxValue(6);
        sectionsPicker.setDisplayedValues(sections);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,SignInActivity.class);
        dataReceived(intent);
        startActivity(intent);
    }

    private void dataReceived(Intent intent){

    }
}
