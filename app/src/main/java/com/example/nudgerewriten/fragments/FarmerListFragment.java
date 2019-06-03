package com.example.nudgerewriten.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.adapters.Adapter_contact_list_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

        final RecyclerView farmer_contact_recycler = view.findViewById(R.id.farmer_contact_recycler);
        fabAdd = view.findViewById(R.id.fab_add);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Add the farmer.", Toast.LENGTH_SHORT).show();
            }
        });

        farmer_contact_recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        final String[] data = {"Ankit Singh", "Priyanka Patil", "Aman Mohanty", "Krishna Pati", "Adyusha Pradhan", "Rahul Gupta", "Rohit Singh", "Kapoora Todo", "Dest 4", "Eest 5", "Fest 6", "Gest 7", "Hest 8", "Iest 9"};
        Arrays.sort(data);
        farmer_contact_recycler.setAdapter(new Adapter_contact_list_1(data));

        SearchView farmerlist_searchview = view.findViewById(R.id.farmerlist_searchview);

        farmerlist_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            List<String> filterOnChange = Arrays.asList(data);

            List<String> filterOnSubmit = new ArrayList<>();
            @Override
            public boolean onQueryTextSubmit(String s) {
                List<String> filterData = new ArrayList<>();
                for (String filter : data
                ) {
                    if (s.length()<=filter.length()) {

                        if (s.equalsIgnoreCase(filter.substring(0, s.length()))) {
                            filterData.add(filter);
                        }
                    }
                    Log.i("search", "filter: " + filterData);
                }

                if (!filterData.isEmpty())
                    farmer_contact_recycler.setAdapter(new Adapter_contact_list_1(filterData.toArray(new String[0])));

                else {
                    Toast toast=Toast.makeText(getContext(), "No contacts found", Toast.LENGTH_SHORT);
                    toast.show();
                    farmer_contact_recycler.setAdapter(new Adapter_contact_list_1(data));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                List<String> filterData = new ArrayList<>();
                    for (String filter : data
                    ) {
                        if (s.length()<=filter.length()) {

                            if (s.equalsIgnoreCase(filter.substring(0, s.length()))) {
                                filterData.add(filter);
                            }
                        }
                        Log.i("search", "filter: " + filterData);
                    }

                    if (!filterData.isEmpty())
                        farmer_contact_recycler.setAdapter(new Adapter_contact_list_1(filterData.toArray(new String[0])));

                    else {

                        Toast toast=Toast.makeText(getContext(), "No contacts found", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.HORIZONTAL_GRAVITY_MASK,0,0);
                        toast.show();
                        farmer_contact_recycler.setAdapter(new Adapter_contact_list_1(data));
                    }
                    return false;
            }

        });

    }

}