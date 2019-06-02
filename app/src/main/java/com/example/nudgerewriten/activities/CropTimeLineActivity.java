package com.example.nudgerewriten.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nudgerewriten.R;

import java.util.ArrayList;
import java.util.List;

public class CropTimeLineActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_time_line);

        List<String> sources = new ArrayList<>();

        sources.add("Start");
        sources.add("Design");
        sources.add("Code");
        sources.add("Test");
        sources.add("Maintain");

    }
}
