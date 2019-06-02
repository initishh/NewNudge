package com.example.nudgerewriten.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.adapters.VisitsAdapter;

import java.util.ArrayList;
import java.util.List;

public class VisitsActivity extends AppCompatActivity {

    ImageView backBtn;
    RecyclerView todaysRcv,pendingRcv;
    VisitsAdapter adapter1,adapter2;
    List<String> farmerNames = new ArrayList<>();
    List<String> visitTitles = new ArrayList<>();
    List<String> date = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        backBtn = findViewById(R.id.back_btn1);
        todaysRcv = findViewById(R.id.todays_rcv);
        pendingRcv = findViewById(R.id.pending_rcv);

        farmerNames.add("John Doe");
        farmerNames.add("Pablo Escobar");
        farmerNames.add("Skyler White");
        farmerNames.add("Walter White");
        farmerNames.add("Daft Punk");

        visitTitles.add("Fertilizer Requirement");
        visitTitles.add("Crop Details");
        visitTitles.add("Crop Fertilizer Time");
        visitTitles.add("Fertilizer for Plant");
        visitTitles.add("Fertilizer Requirement");

        date.add("29th April,2019");
        date.add("29th May,2019");
        date.add("29th June,2019");
        date.add("29th July,2019");
        date.add("29th August,2019");

        todaysRcv.setLayoutManager(new LinearLayoutManager(this));
        todaysRcv.setItemAnimator(new DefaultItemAnimator());
        todaysRcv.setNestedScrollingEnabled(false);

        adapter1 = new VisitsAdapter(farmerNames,visitTitles,date,this);
        todaysRcv.setAdapter(adapter1);

        adapter2 = new VisitsAdapter(new ArrayList<String>(farmerNames.subList(1,3)), new ArrayList<String>(visitTitles.subList(1,3)),new ArrayList<String>(date.subList(1,3)),this);
        pendingRcv.setLayoutManager(new LinearLayoutManager(this));
        pendingRcv.setItemAnimator(new DefaultItemAnimator());
        pendingRcv.setNestedScrollingEnabled(false);
        pendingRcv.setAdapter(adapter2);

        FloatingActionButton fab = findViewById(R.id.visits_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),NewVisitActivity.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
