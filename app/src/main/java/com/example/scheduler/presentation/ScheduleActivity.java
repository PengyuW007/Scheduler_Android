package com.example.scheduler.presentation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scheduler.R;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        showResult();
    }//end onCreate

    private void showResult(){
        Bundle bundle = getIntent().getExtras();

        String people = bundle.getString("number_of_people");
        Log.i("StartScheduleActivity","Number of people: "+people);
        String shifts = bundle.getString("number_of_shifts");
        Log.i("StartScheduleActivity","Number of shifts: "+shifts);

        TextView textViewPeople = findViewById(R.id.schedule_people);
        textViewPeople.setText("Number of people: "+people);
        TextView textViewShifts = findViewById(R.id.schedule_shifts);
        textViewShifts.setText("Number of shifts:"+shifts);
    }

    @Override
    public void onClick(View view) {

    }
}
