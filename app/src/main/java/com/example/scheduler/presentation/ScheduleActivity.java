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
import com.example.scheduler.objects.Shift;
import com.example.scheduler.presentation.DayTimeAdapter;

import java.util.ArrayList;


public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {
    private GridView gridView;
    private DayTimeAdapter dayTimeAdapter;
    private ArrayList<Shift> checkedList;
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
        /** Toolbar ***/
        toolbar = (Toolbar) findViewById(R.id.toolbar_service);

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

        /*** Grid ***/
        gridView = (GridView) findViewById(R.id.schedule_grid);
        for (int i = 0; i < 21; i++) {
            checkedList.add(new Shift(R.mipmap.ico_seltime, 0, false));
        }
        dayTimeAdapter = new DayTimeAdapter(ScheduleActivity.this, checkedList);

        gridView.setAdapter(dayTimeAdapter);
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
