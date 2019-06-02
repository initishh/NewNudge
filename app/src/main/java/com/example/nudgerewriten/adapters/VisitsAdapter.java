package com.example.nudgerewriten.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nudgerewriten.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VisitsAdapter extends RecyclerView.Adapter<VisitsAdapter.myViewHolder> {

    List<String> farmerNames,visitTitle,date;
    Context context;
    static int currentPosition = -1;

    public VisitsAdapter(List<String> farmerNames, List<String> visitTitle, List<String> date, Context context) {
        this.farmerNames = farmerNames;
        this.visitTitle = visitTitle;
        this.date = date;
        this.context = context;
    }

    @NonNull
    @Override
    public VisitsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View v = mInflater.inflate(R.layout.farmers, viewGroup, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitsAdapter.myViewHolder myViewHolder, final int i) {

        myViewHolder.farmerName.setText(farmerNames.get(i));
        myViewHolder.visitTitle.setText(visitTitle.get(i));
        myViewHolder.visitDate.setText(date.get(i));
        myViewHolder.visitChildView.setVisibility(View.GONE);

        if(currentPosition == i) {
            myViewHolder.visitChildView.setVisibility(View.VISIBLE);
        }

        myViewHolder.visitCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPosition == i) currentPosition = -1;
                else
                    currentPosition = i;
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return farmerNames.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        CircleImageView farmerImage;
        TextView visitTitle,farmerName,visitDate;
        ConstraintLayout visitChildView;
        CardView visitCard;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            farmerImage = itemView.findViewById(R.id.farmer_image);
            visitTitle = itemView.findViewById(R.id.visit_title);
            farmerName = itemView.findViewById(R.id.farmer_name);
            visitDate = itemView.findViewById(R.id.visit_date);
            visitCard = itemView.findViewById(R.id.visit_order_card);
            visitChildView = itemView.findViewById(R.id.visit_child_view);
        }
    }
}
