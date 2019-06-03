package com.example.nudgerewriten.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.adapters.RecyclerAdapter;
import com.example.nudgerewriten.models.crop;

import java.util.ArrayList;

public class CropAndMarketFragment extends Fragment {

    private RecyclerView recyclerView;
    private int[] images = {R.drawable.component, R.drawable.component1, R.drawable.component2,
            R.drawable.component3, R.drawable.component4, R.drawable.component5};
    private String[] croplist = {"Potato", "Chilly", "Tomato", "Carrot", "Onion", "Garlic"};
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private Toolbar toolbar;
    private ArrayList<crop> cropsList = new ArrayList<>();
    Context context = getActivity();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crop_and_market, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);

        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        int count = 0;
        for (String name : croplist) {
            cropsList.add(new crop(name, images[count]));
            count++;
        }
        adapter = new RecyclerAdapter(cropsList,context);
        recyclerView.setAdapter(adapter);
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
    }
}