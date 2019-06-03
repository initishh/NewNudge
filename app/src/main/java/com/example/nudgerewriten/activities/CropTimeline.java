package com.example.nudgerewriten.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.nudgerewriten.R;

import org.qap.ctimelineview.TimelineRow;
import org.qap.ctimelineview.TimelineViewAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CropTimeline extends AppCompatActivity {

    ArrayList<TimelineRow> timelineRowsList = new ArrayList<>();
    Toolbar toolbar;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_timeline);

        toolbar = findViewById(R.id.toolbar);
        backBtn = findViewById(R.id.back_btn1);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        TimelineRow myRow = new TimelineRow(0);

        myRow.setTitle("Day 1");
        myRow.setDescription("Mon 3 May, 2019\n" +
                "\n"+"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        myRow.setImage(getBitmap(R.drawable.timeline_circle));
        myRow.setBellowLineColor(Color.parseColor("#3CCC00"));
        myRow.setBellowLineSize(1);
        myRow.setImageSize(40);
        timelineRowsList.add(myRow);

        myRow = new TimelineRow(0);

        myRow.setTitle("Day 5");
        myRow.setDescription("Friday 8 May, 2019\n" +
                "\n"+"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        myRow.setImage(getBitmap(R.drawable.timeline_circle));
        myRow.setBellowLineColor(Color.parseColor("#3CCC00"));
        myRow.setBellowLineSize(1);
        myRow.setImageSize(40);
        timelineRowsList.add(myRow);

        myRow = new TimelineRow(0);

        myRow.setTitle("Day 7");
        myRow.setDescription("Sun 10 May, 2019\n" +
                "\n"+"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        myRow.setImage(getBitmap(R.drawable.timeline_circle));
        myRow.setBellowLineColor(Color.parseColor("#3CCC00"));
        myRow.setBellowLineSize(1);
        myRow.setImageSize(40);
        timelineRowsList.add(myRow);

        myRow = new TimelineRow(0);

        myRow.setTitle("Day 10");
        myRow.setDescription("Wed 13 April, 2019\n" +
                "\n"+"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        myRow.setImage(getBitmap(R.drawable.timeline_circle));
        myRow.setBellowLineColor(Color.parseColor("#3CCC00"));
        myRow.setBellowLineSize(1);
        myRow.setImageSize(40);
        timelineRowsList.add(myRow);



// Create the Timeline Adapter
        ArrayAdapter<TimelineRow> myAdapter = new TimelineViewAdapter(this, 0, timelineRowsList,
                //if true, list will be sorted by date
                false);

// Get the ListView and Bind it with the Timeline Adapter
        ListView myListView = (ListView) findViewById(R.id.timeline_listView);
        myListView.setAdapter(myAdapter);
    }

    private Bitmap getBitmap(int drawableRes) {
        Drawable drawable = getResources().getDrawable(drawableRes);
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

}
