package com.aris.kuryerol.activities.drawermenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.drawermenu.adapter.ListViewAdaptor;
import com.aris.kuryerol.activities.expandleList.Models;

import java.util.ArrayList;
import java.util.List;

public class FasileActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ListViewAdaptor mAdapter;
    private List<Models> mDataList = new ArrayList<>();

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasile);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ListViewAdaptor(mDataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        prepareList();
    }

    public void prepareList(){
        Models data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
        data = new Models("Sakura","4.50 AZN",R.drawable.ic_rectangle_copy_9);
        mDataList.add(data);
    }

}