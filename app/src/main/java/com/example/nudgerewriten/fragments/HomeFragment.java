package com.example.nudgerewriten.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.activities.OrdersActivity;
import com.example.nudgerewriten.activities.VisitsActivity;
import com.example.nudgerewriten.adapters.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView prodRcvId;
    TextView visitId,orderId;
    List<String> Products = new ArrayList<>();
    Toolbar toolbar;

    ProductAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);

        for(int i =1;i<=6;i++)
            Products.add("Product "+i);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.home_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prodRcvId = getView().findViewById(R.id.prod_rcv_id);
        orderId = getView().findViewById(R.id.order_id);
        visitId = getView().findViewById(R.id.visit_id);

        toolbar = getView().findViewById(R.id.toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.notifs)
                {   Toast.makeText(getActivity(), "You have 0 notifications.", Toast.LENGTH_SHORT).show();
                    return true; }
                else if(item.getItemId() == R.id.cart) {
                    Toast.makeText(getActivity(), "You have 0 items in cart", Toast.LENGTH_SHORT).show();
                    return true;
                } else return false;
            }
        });


        prodRcvId.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.HORIZONTAL,false));
        adapter = new ProductAdapter(Products,getActivity());
        prodRcvId.setAdapter(adapter);

        orderId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OrdersActivity.class));
            }
        });

        visitId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VisitsActivity.class));
            }
        });

    }
}