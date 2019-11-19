package com.aris.kuryerol.activities.drawermenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.expandleList.ExpandleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchiveActivity extends Activity {

    ExpandleAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader =new ArrayList<>();
    HashMap<String, List<Object>> listDataChild = new HashMap<>();
    private static final String TAG = "ArchiveActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);
        // get the listview
        expListView = findViewById(R.id.lvExp);
        // preparing list data

        Log.e(TAG, "onCreate: "+listDataHeader );
        Log.e(TAG, "onCreate: "+listDataChild );
        listAdapter = new ExpandleAdapter( listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

        prepareListData();
        listAdapter.notifyDataSetChanged();

        // setting list adapter
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader.add("YG - 102345");
        listDataHeader.add("YG - 1023456");


        // Adding child data
        List<Object> top250 = new ArrayList<>();
        top250.add("M. Axundov 26");
        top250.add(2.0);
        top250.add(2.0);
        top250.add(2.0);
        top250.add(2.0);
        top250.add(2.0);
        top250.add(2.0);
        top250.add(1.1f);




        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), top250); // Header, Child data
    }
}