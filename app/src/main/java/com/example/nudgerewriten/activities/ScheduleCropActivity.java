package com.example.nudgerewriten.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.nudgerewriten.R;

public class ScheduleCropActivity extends AppCompatActivity {

    ImageView backBtn;
    EditText farmSizeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_crop);

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        farmSizeId = findViewById(R.id.farm_size_id);
        farmSizeId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                farmSizeId.setCursorVisible(true);
            }
        });
    }
}
