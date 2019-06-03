package com.example.nudgerewriten.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.models.crop;

public class SelectedCropActity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_crop_actity);

//        Intent intent=getIntent();
//        crop crop=intent.getParcelableExtra("Crop Name");

//        int cropimage = crop.getCropimage();
//        String cropname = crop.getCropname();

        ImageView imageView = findViewById(R.id.selectedCropImage);
        imageView.setImageResource(R.drawable.tomatoes);
        TextView textView1 = findViewById(R.id.selectedCropName);
        textView1.setText("Tomatoes");
    }
}
