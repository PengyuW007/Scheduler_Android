package com.example.scheduler.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scheduler.R;

public class StartScheduleActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView people, shifts;
    private NumberPicker peoplePicker, shiftsPicker;
    private String num_people, num_shifts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        pickerUI();

        findViewById(R.id.start_button_previous).setOnClickListener(this);
        findViewById(R.id.start_button_next).setOnClickListener(this);
    }//end onCreate

    private void pickerUI(){
        // People Picker //
        people = findViewById(R.id.start_text_people);//people picker title
        peoplePicker = (NumberPicker) findViewById(R.id.start_numPicker_people);
        peoplePicker.setMinValue(0);
        peoplePicker.setMaxValue(10);

        // Shifts Picker //
        shifts = findViewById(R.id.start_text_shift);//shift picker title
        shiftsPicker = (NumberPicker) findViewById(R.id.start_numPicker_shifts);
        shiftsPicker.setMinValue(0);
        shiftsPicker.setMaxValue(10);
    }//end pickerUI

    @Override
    public void onClick(View view) {
        Intent intent =  new Intent(this,ScheduleActivity.class);
        picker(intent);

        if (view.getId() == R.id.start_button_next) {
            intent.setClass(getApplicationContext(), ScheduleActivity.class);
        } else if (view.getId() == R.id.start_button_previous) {
            intent.setClass(getApplicationContext(), SignInActivity.class);
        }
        startActivity(intent);
    }//end onClick

    private void picker(Intent intent) {
        num_people = peoplePicker.getValue()+"";
        intent.putExtra("number_of_people", num_people);

        num_shifts = shiftsPicker.getValue()+"";
        intent.putExtra("number_of_shifts", num_shifts);
    }//end picker
}
