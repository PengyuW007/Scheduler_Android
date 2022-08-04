package com.example.scheduler.presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scheduler.R;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;
    String[] time_split = {"Morning", "Afternoon", "Night",
            "Morning", "Afternoon", "Night",
            "Morning", "Afternoon", "Night",
            "Morning", "Afternoon", "Night",
            "Morning", "Afternoon", "Night",
            "Morning", "Afternoon", "Night",
            "Morning", "Afternoon", "Night"};
    int[] time_image = {R.drawable.icon_time_selector, R.drawable.icon_time_selector, R.drawable.icon_time_selector,
            R.drawable.icon_time_selector, R.drawable.icon_time_selector, R.drawable.icon_time_selector,
            R.drawable.icon_time_selector, R.drawable.icon_time_selector, R.drawable.icon_time_selector,
            R.drawable.icon_time_selector, R.drawable.icon_time_selector, R.drawable.icon_time_selector,
            R.drawable.icon_time_selector, R.drawable.icon_time_selector, R.drawable.icon_time_selector,
            R.drawable.icon_time_selector, R.drawable.icon_time_selector, R.drawable.icon_time_selector,
            R.drawable.icon_time_selector, R.drawable.icon_time_selector, R.drawable.icon_time_selector,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        //showResult();
        setGridView();
    }//end onCreate

    public void setGridView() {
        gridView = findViewById(R.id.schedule_grid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getApplicationContext(),"You choose: "+time_split[pos],Toast.LENGTH_SHORT).show();
            }
        });
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

    @Override
    public void onClick(View view) {

    }
}
