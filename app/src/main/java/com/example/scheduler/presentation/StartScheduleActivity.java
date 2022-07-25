package com.example.scheduler.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scheduler.R;

public class StartScheduleActivity extends AppCompatActivity implements View.OnClickListener {
    TextView people, shifts;
    NumberPicker peoplePicker, shiftsPicker;
    int num_people, num_shifts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        picker();
    }//end onCreate

    private void picker() {
        // People Picker //
        people = findViewById(R.id.people);//people picker title

        peoplePicker = findViewById(R.id.people_picker);
        peoplePicker.setMinValue(0);
        peoplePicker.setMaxValue(10);
        peoplePicker.setOnValueChangedListener((numberPicker, oldVal, newVal) -> num_people = newVal);

        // Shifts Picker //
        shifts = findViewById(R.id.shift);//shift picker title

        shiftsPicker = findViewById(R.id.shifts_picker);
        shiftsPicker.setMinValue(0);
        shiftsPicker.setMaxValue(10);
        shiftsPicker.setOnValueChangedListener((numberPicker, oldVal, newVal) -> num_shifts = newVal);

        findViewById(R.id.next_button).setOnClickListener(this);
        findViewById(R.id.previous_button).setOnClickListener(this);
    }//end picker

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();

        if(view.getId()==R.id.next_button){
            intent.setClass(getApplicationContext(),ScheduleActivity.class);
            startActivity(intent);
        }else if(view.getId()==R.id.previous_button){
            intent.setClass(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
    }
}
