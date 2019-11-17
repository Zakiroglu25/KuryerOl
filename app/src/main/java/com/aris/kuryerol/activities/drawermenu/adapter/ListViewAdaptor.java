package com.aris.kuryerol.activities.drawermenu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.expandleList.Models;

import java.util.List;

public class ListViewAdaptor extends RecyclerView.Adapter<ListViewAdaptor.MyViewHolder> {

    private List<Models> mDataList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name,price;
        public ImageView imageView;

        public MyViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            price= (TextView) view.findViewById(R.id.price);
            imageView = (ImageView) view.findViewById(R.id.image);
        }
    }

    public ListViewAdaptor(List<Models> dataList){
        this.mDataList = dataList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Models models= mDataList.get(position);
        holder.name.setText(models.getName());
        holder.price.setText(models.getPrice());
        holder.imageView.setImageResource(models.getImage());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}