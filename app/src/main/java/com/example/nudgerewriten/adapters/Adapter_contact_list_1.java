package com.example.nudgerewriten.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nudgerewriten.R;

import java.util.ArrayList;

public class Adapter_contact_list_1 extends RecyclerView.Adapter<Adapter_contact_list_1.Adapter_contact_list_1_ViewHolder> {

    public String[] data;
    public Adapter_contact_list_1(String[] data){
        this.data= data;
    }

    @NonNull
    @Override
    public Adapter_contact_list_1_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_farmer_list_1,viewGroup,false);
        return new Adapter_contact_list_1_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_contact_list_1_ViewHolder adapter_contact_list_1_viewHolder, int i) {
        int count=0;
        ArrayList<String> cardList = new ArrayList<String>();
        char c=data[0].charAt(0),c2;
        for (String cont:
                data) {
            c2=cont.charAt(0);
            if (c!=c2){
                count++;
                c=c2;
            }
            if (count == i+1)
                break;

            if (count==i){
                cardList.add(cont);
            }

        }
        adapter_contact_list_1_viewHolder.contact_list_recycler.setAdapter(new Adapter_contact_list_2((cardList.toArray(new String[(cardList.size())]))));
        adapter_contact_list_1_viewHolder.contact_list_alphabet.setText(String.valueOf(cardList.get(0).charAt(0)));

    }

    @Override
    public int getItemCount() {
        int count=0;
        char c=data[0].charAt(0),c2;
        for (String cont: data) {
            c2=cont.charAt(0);
            if (c!=c2){
                count++;
                c=c2;
            }

        }
        return count+1;
    }

    public class Adapter_contact_list_1_ViewHolder extends RecyclerView.ViewHolder{
        TextView contact_list_alphabet;
        CardView contact_list_card;
        RecyclerView contact_list_recycler;

        public Adapter_contact_list_1_ViewHolder(View itemView){
            super(itemView);
            contact_list_recycler = itemView.findViewById(R.id.contact_list_recycler);
            contact_list_recycler.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            contact_list_card = itemView.findViewById(R.id.contact_list_card);
            contact_list_alphabet = itemView.findViewById(R.id.contact_list_alphabet);
        }
    }
}
