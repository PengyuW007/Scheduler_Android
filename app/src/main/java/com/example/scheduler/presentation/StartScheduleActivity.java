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
        Intent intent = new Intent();
        // People Picker //
        people = findViewById(R.id.start_text_people);//people picker title

        peoplePicker = findViewById(R.id.start_numPicker_people);
        peoplePicker.setMinValue(0);
        peoplePicker.setMaxValue(10);
        peoplePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                num_people = newVal;
                intent.putExtra("number_of_people",num_people);
            }
        });

        // Shifts Picker //
        shifts = findViewById(R.id.start_text_shift);//shift picker title

        shiftsPicker = findViewById(R.id.start_numPicker_shifts);
        shiftsPicker.setMinValue(0);
        shiftsPicker.setMaxValue(10);
        shiftsPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                num_shifts = newVal;
                intent.putExtra("number_of_Shifts",num_shifts);
            }
        });// num_shifts, num_people received //

        findViewById(R.id.start_button_next).setOnClickListener(this);
        findViewById(R.id.start_button_previous).setOnClickListener(this);
    }//end picker

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();

        if(view.getId()==R.id.start_button_next){
            intent.setClass(getApplicationContext(),ScheduleActivity.class);
        }else if(view.getId()==R.id.start_button_previous){
            intent.setClass(getApplicationContext(),MainActivity.class);
        }
        startActivity(intent);
    }
}
