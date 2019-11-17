package com.aris.kuryerol.activities.drawermenu.archiveRv;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.expandleList.Models;
import com.aris.kuryerol.activities.helpers.BaseRecyclerVH;
import com.aris.kuryerol.activities.helpers.Utils;

public class NameAndPrice extends BaseRecyclerVH {
    private static int layoutId = R.layout.list_view_item;

    private ImageView categoryIv;
    private TextView categoryTv;

    private static final String TAG = "CategoryChildVH";

    private NameAndPrice(@NonNull View itemView) {
        super(itemView);

        categoryIv = itemView.findViewById(R.id.image);
        //categoryTv = itemView.findViewById(R.id.category_tv);
    }

    public void build(Models models, int size) {
        categoryIv.setImageResource(models.getImage());
        categoryTv.setText(models.getName());


        if (getAdapterPosition() == size-1) {
            itemView.setPadding(0,0,0,0);

        }else {
            itemView.setPadding(0,0, Utils.dpToPx(24,itemView.getContext()),0);

        }
    }

    public static NameAndPrice create(ViewGroup parent) {
        return new NameAndPrice(view(parent, layoutId));
    }
}

