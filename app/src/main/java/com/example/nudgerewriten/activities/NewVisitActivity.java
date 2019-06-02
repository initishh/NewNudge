package com.example.nudgerewriten.activities;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.fragments.DatePickerFragment;
import com.example.nudgerewriten.fragments.TimePickerFragment;

import java.util.Calendar;

public class NewVisitActivity extends AppCompatActivity {

    ImageView crossBtn;
    EditText visitTitle;
    TextView contactSearchBtn,dateBtn,timeBtn;
    Button saveBtn;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_visit);

        crossBtn = findViewById(R.id.cross_btn);
        visitTitle = findViewById(R.id.visit_title);
        contactSearchBtn = findViewById(R.id.contact_search_btn);
        saveBtn = findViewById(R.id.save_btn);
        dateBtn = findViewById(R.id.date_btn);
        timeBtn = findViewById(R.id.time_btn);
        aSwitch = findViewById(R.id.switch1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) timeBtn.setVisibility(View.INVISIBLE);
            }
        });

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datepicker");
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getSupportFragmentManager(), "timepicker");
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        contactSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactSearchBtn.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            }
        });

        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void processDatePickerResult(int year, int month, int day, String date) {
        dateBtn.setText(date);
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        // Convert time elements into strings.

        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        if(hourOfDay<10) hour_string = "0"+hour_string;
        if(minute<10) minute_string = "0"+minute_string;

        String time = (hourOfDay < 12) ? hour_string + ":"+minute_string+" AM" : Integer.toString(hourOfDay-12) + ":"+minute_string+" PM";

        timeBtn.setText(time);
    }
}
