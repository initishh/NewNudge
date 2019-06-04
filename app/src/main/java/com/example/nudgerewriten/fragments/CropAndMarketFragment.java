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
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.adapters.Adapter_contact_list_1;
import com.example.nudgerewriten.adapters.RecyclerAdapter;
import com.example.nudgerewriten.models.crop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CropAndMarketFragment extends Fragment {

    private RecyclerView recyclerView;
    private int[] images = {R.drawable.component, R.drawable.component1, R.drawable.component2,
            R.drawable.component3, R.drawable.component4, R.drawable.component5};
    private ArrayList<String> croplist=new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private SearchView crop_market_searchview;
    private ArrayList<crop> cropsList = new ArrayList<>();
    Context context = getActivity();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crop_and_market, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

//        {"Potato", "Chilly", "Tomato", "Carrot", "Onion", "Garlic"}

        croplist.add("Potato");
        croplist.add("Chilly");
        croplist.add("Tomato");
        croplist.add("Carrot");
        croplist.add("Onion");
        croplist.add("Garlic");


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
        crop_market_searchview = view.findViewById(R.id.crop_market_searchview);

        crop_market_searchview.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {

            List<String> filterOnChange = croplist;

            List<String> filterOnSubmit = new ArrayList<>();
            @Override
            public boolean onQueryTextSubmit(String s) {
                ArrayList<crop> filterData = new ArrayList<>();
                for (String filter : croplist
                ) {
                    if (s.length()<=filter.length()) {

                        if (s.equalsIgnoreCase(filter.substring(0, s.length()))) {
                            filterData.add(new crop(filter,images[croplist.indexOf(filter)]));
                        }
                    }
                    Log.i("search", "filter: " + filterData);
                }

                if (!filterData.isEmpty()){

                    adapter = new RecyclerAdapter(filterData,context);
                    recyclerView.setAdapter(adapter);


                }
                else {
                    Toast toast=Toast.makeText(getContext(), "No contacts found", Toast.LENGTH_SHORT);
                    toast.show();
                    adapter = new RecyclerAdapter(cropsList,context);
                    recyclerView.setAdapter(adapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<crop> filterData = new ArrayList<>();
                for (String filter : croplist
                ) {
                    if (s.length()<=filter.length()) {

                        if (s.equalsIgnoreCase(filter.substring(0, s.length()))) {
                            filterData.add(new crop(filter,images[croplist.indexOf(filter)]));
                        }
                    }
                    Log.i("search", "filter: " + filterData);
                }

                if (!filterData.isEmpty()){

                    adapter = new RecyclerAdapter(filterData,context);
                    recyclerView.setAdapter(adapter);


                }
                else {
                    Toast toast=Toast.makeText(getContext(), "No contacts found", Toast.LENGTH_SHORT);
                    toast.show();
                    adapter = new RecyclerAdapter(cropsList,context);
                    recyclerView.setAdapter(adapter);
                }
                return false;

            }

        });




    }
}