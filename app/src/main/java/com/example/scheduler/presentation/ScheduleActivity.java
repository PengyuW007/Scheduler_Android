package com.example.scheduler.presentation;

import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scheduler.R;
//import com.example.scheduler.presentation.WeekTimeAdapter;
import com.example.scheduler.business.Checked;
import com.example.scheduler.presentation.DayTimeAdapter;

import java.util.ArrayList;
import java.util.List;


public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {
    private GridView gridView;
    private DayTimeAdapter dayTimeAdapter;
    private List<Checked> checkedList;
    private TextView save;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        checkedList = new ArrayList<>();


        initUI();

    }

    private void initUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_service);

        gridView = (GridView) findViewById(R.id.schedule_grid);

        save = (TextView) findViewById(R.id.save_work);
        save.setOnClickListener(this);

        toolbar.setNavigationIcon(R.mipmap.left_m);//set navigation button
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {

    }

    private void showResult() {
        Bundle bundle = getIntent().getExtras();

        String people = bundle.getString("number_of_people");
        Log.i("StartScheduleActivity", "Number of people: " + people);
        String shifts = bundle.getString("number_of_shifts");
        Log.i("StartScheduleActivity", "Number of shifts: " + shifts);

        /*
        TextView textViewPeople = findViewById(R.id.schedule_people);
        textViewPeople.setText("Number of people: "+people);
        TextView textViewShifts = findViewById(R.id.schedule_shifts);
        textViewShifts.setText("Number of shifts: "+shifts);

         */
    }
}
