package com.example.nudgerewriten.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nudgerewriten.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.myViewHolder> {

    List<String> products;
    Context context;

    public ProductAdapter(List<String> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View v = mInflater.inflate(R.layout.prod_layout_home, viewGroup, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {

        myViewHolder.prod_id.setText(products.get(i));
        myViewHolder.prod_image.setImageDrawable(context.getResources().getDrawable(R.drawable.fertilizer));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView prod_id;
        ImageView prod_image;

        public myViewHolder(@NonNull View itemView) {

            super(itemView);
            prod_image = itemView.findViewById(R.id.prod_image);
            prod_id = itemView.findViewById(R.id.prod_id);
        }
    }
}
