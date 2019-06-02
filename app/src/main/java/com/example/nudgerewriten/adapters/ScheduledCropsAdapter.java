package com.example.nudgerewriten.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.activities.CropTimeLineActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ScheduledCropsAdapter extends RecyclerView.Adapter<ScheduledCropsAdapter.MyCustomViewHolder> {

    List<String> Crops;
    List<String> Dates;
    Context context;

    public ScheduledCropsAdapter(List<String> crops, List<String> dates, Context context) {
        Crops = crops;
        Dates = dates;
        this.context = context;
    }

    @NonNull
    @Override
    public MyCustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.scheduledcrop,viewGroup,false);
        return new MyCustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomViewHolder myCustomViewHolder, final int i) {

        myCustomViewHolder.cropName.setText(Crops.get(i));

        myCustomViewHolder.cropId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CropTimeLineActivity.class));
            }
        });

//        Picasso.get().load("https://imgur.com/xuyhj5U").into(myCustomViewHolder.cropImage);
    }

    @Override
    public int getItemCount() {
        return Crops.size();
    }

    public class MyCustomViewHolder extends RecyclerView.ViewHolder {

        ImageView cropImage;
        TextView cropName;
        ConstraintLayout cropId;

        public MyCustomViewHolder(@NonNull View itemView) {
            super(itemView);
            cropImage = itemView.findViewById(R.id.crop_image);
            cropName = itemView.findViewById(R.id.crop_name);
            cropId = itemView.findViewById(R.id.crop_id);
        }
    }
}
