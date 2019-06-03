package com.example.nudgerewriten.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.activities.SelectedCropActity;
import com.example.nudgerewriten.models.crop;

import java.util.ArrayList;

public class RecyclerAdapter extends Adapter<RecyclerAdapter.ImageViewHolder> {

    private ArrayList<crop> cropList;
    Context context;

    public RecyclerAdapter(ArrayList<crop> crops,Context context){
        this.context =context;
        this.cropList=crops;
    }
    @Nullable
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.croplist,viewGroup,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {

        viewHolder.crop.setImageResource(cropList.get(i).getCropimage());
        viewHolder.croptitle.setText(cropList.get(i).getCropname());

        viewHolder.crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), SelectedCropActity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cropList.size();
    }

    public static class  ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView crop;
        TextView croptitle;

        public ImageViewHolder(@NonNull final View itemView) {
            super(itemView);
            crop=  (ImageView) itemView.findViewById(R.id.crop);
            croptitle=(TextView) itemView.findViewById(R.id.croptitle);
        }
    }

}