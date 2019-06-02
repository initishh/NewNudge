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

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.myViewHolder> {

    List<String> farmers;
    List<String> orderTypes,dates;
    Context context;
    static int currentPosition = -1;
    List<Integer> flag;

    public OrdersAdapter(List<String> farmers, List<String> orderTypes, List<String> dates, List<Integer> flag, Context context) {
        this.farmers = farmers;
        this.orderTypes = orderTypes;
        this.dates = dates;
        this.flag = flag;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View v = mInflater.inflate(R.layout.orders_fertilizer_card, viewGroup, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.myViewHolder myViewHolder, final int i) {

        myViewHolder.farmerName.setText(farmers.get(i));
        myViewHolder.type.setText(orderTypes.get(i));
        myViewHolder.orderDate.setText((dates.get(i)));
        myViewHolder.childView.setVisibility(View.GONE);

        if(currentPosition == i && flag.get(0)==2) {
            myViewHolder.childView.setVisibility(View.VISIBLE);
        }

        myViewHolder.orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        myViewHolder.orderCard.setOnClickListener(new View.OnClickListener() {
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
        return farmers.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView farmerName,type,orderDate,orderBtn;
        ConstraintLayout childView;
        CardView orderCard;

        public myViewHolder(@NonNull View itemView) {

            super(itemView);
            farmerName = itemView.findViewById(R.id.farmer_name);
            type = itemView.findViewById(R.id.type);
            orderDate = itemView.findViewById(R.id.visit_date);
            orderBtn = itemView.findViewById(R.id.order_btn);
            childView = itemView.findViewById(R.id.visit_child_view);
            orderCard = itemView.findViewById(R.id.visit_order_card);
        }
    }
}
