package com.example.lab5.placeholder;


import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5.Entitiy.ItemData;
import com.example.lab5.ListFragment;
import com.example.lab5.ListFragmentInteractionListener;
import com.example.lab5.R;

import java.util.List;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyViewHolder> {
    private List<ItemData> itemData;
    private  final ListFragmentInteractionListener listeners;

    public MyRVAdapter(ListFragmentInteractionListener listeners) {
        this.listeners = listeners;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemData = itemData.get(position);
        holder.firstName.setText(holder.itemData.firstName);
        holder.lastName.setText(holder.itemData.lastName);
        holder.age.setText(holder.itemData.age);
        String gender = holder.itemData.gender;
        if (gender.equals("Female")){
            holder.gender.setImageResource(R.drawable.female);
        }else if (gender.equals("Male")){
            holder.gender.setImageResource(R.drawable.male);
        }else {
            holder.gender.setImageResource(R.drawable.download);
        }
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listeners != null){
                    listeners.onDeleteItem(holder.itemData);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (itemData != null){
            return itemData.size();
        }
        return 0;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void setItemData(List<ItemData> itemDataList){
        itemData = itemDataList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView firstName;
        public final  TextView lastName;
        public final TextView age;
        public final ImageView gender;
        public ItemData itemData;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            firstName = (TextView) itemView.findViewById(R.id.firstName);
            lastName = (TextView) itemView.findViewById(R.id.lastName);
            age = (TextView) itemView.findViewById(R.id.Age);
            gender = (ImageView) itemView.findViewById(R.id.genderPicture);

        }
    }
}
