package com.example.nudgerewriten.activities;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.adapters.ScheduledCropsAdapter;
import com.rhexgomez.typer.roboto.TyperRoboto;

import java.util.ArrayList;
import java.util.List;

public class FarmerProfileActivity extends AppCompatActivity {

    ImageView backBtn;
    Toolbar toolbar;
    TextView scheduleBtn;
    RecyclerView scheduledCropRcv;
    ScheduledCropsAdapter adapter;

    List<String> Crops = new ArrayList<>();
    List<String> Dates = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_profile);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        backBtn = findViewById(R.id.back_btn);
        toolbar = findViewById(R.id.toolbar);

        Crops.add("Tomato");
        Crops.add("Onions");
        Dates.add("3rd May, 2019");
        Dates.add("4th May, 2019");

        scheduleBtn = findViewById(R.id.schedule_btn);
        scheduledCropRcv = findViewById(R.id.scheduled_crop_rcv);

        scheduledCropRcv.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new ScheduledCropsAdapter(Crops,Dates,this);
        scheduledCropRcv.setAdapter(adapter);

        scheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ScheduleCropActivity.class));
            }
        });

        toolbar.inflateMenu(R.menu.actions);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.actions_edit) {
                    Toast.makeText(FarmerProfileActivity.this, "You are about to edit the contact.", Toast.LENGTH_SHORT).show();
                    return true;
                } else if(menuItem.getItemId() == R.id.actions_delete) {
                    Toast.makeText(FarmerProfileActivity.this, "You are about to delete the contact.", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }

}
