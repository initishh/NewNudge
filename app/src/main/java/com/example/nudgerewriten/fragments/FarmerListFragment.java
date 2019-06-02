package com.example.nudgerewriten.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.adapters.Adapter_contact_list_1;

import java.util.Arrays;

public class FarmerListFragment extends Fragment {

    FloatingActionButton fabAdd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_farmerlist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView farmer_contact_recycler =view.findViewById(R.id.farmer_contact_recycler);
        fabAdd = view.findViewById(R.id.fab_add);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Add the farmer.", Toast.LENGTH_SHORT).show();
            }
        });

        farmer_contact_recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        String[] data = {"Ankit Singh","Priyanka Patil","Aman Mohanty","Krishna Pati","Adyusha Pradhan","Rahul Gupta","Rohit Singh","Kapoora Todo","Dest 4","Eest 5","Fest 6","Gest 7","Hest 8","Iest 9"};
        Arrays.sort(data);
        farmer_contact_recycler.setAdapter(new Adapter_contact_list_1(data));

    }
}