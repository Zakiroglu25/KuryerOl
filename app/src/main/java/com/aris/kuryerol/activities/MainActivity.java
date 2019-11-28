package com.aris.kuryerol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.drawermenu.ArchiveActivity;
import com.aris.kuryerol.activities.drawermenu.CallOfficceActivity;
import com.aris.kuryerol.activities.drawermenu.FasileActivity;
import com.aris.kuryerol.activities.drawermenu.OnlineChatActivity;
import com.aris.kuryerol.activities.drawermenu.SifarishlerimActivitiy;
import com.aris.kuryerol.activities.drawermenu.StartWork;
import com.aris.kuryerol.activities.expandleList.ExpandleAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ExpandleAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader =new ArrayList<>();
    HashMap<String, List<Object>> listDataChild = new HashMap<>();
    private static final String TAG = "ArchiveActivity";
    ////////////////////
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    NavigationView navView;
    private SwitchCompat switcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


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
        top250.add(1.1f);

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), top250); // Header, Child data
    }


    private void initViews() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();


        final NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);



//        Menu menu = navigationView.getMenu();
//        MenuItem menuItem = menu.findItem(R.id.nav_switch);
//        View actionView = MenuItemCompat.getActionView(menuItem);
//
//        switcher = (SwitchCompat) actionView.findViewById(R.id.switcher);
//        switcher.setChecked(true);
//        switcher.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(v, (switcher.isChecked()) ? "is checked!!!" : "not checked!!!", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_archive:
                startActivity(new Intent(this, ArchiveActivity.class));
                break;
            case R.id.nav_online_chat:
                startActivity(new Intent(this, OnlineChatActivity.class));
                break;
            case R.id.nav_office_call:
                startActivity(new Intent(this, CallOfficceActivity.class));
                break;
            case R.id.nav_startwork:
                startActivity(new Intent(this, StartWork.class));
                break;
            case R.id.cari_sifaris:
                startActivity(new Intent(this, OrderAccept.class));
                break;
            case R.id.nav_fasile:
                startActivity(new Intent(this, FasileActivity.class));
                break;
            default:
                Toast.makeText(this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void toolbarClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_menu_iv:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.toolbar_message_iv:
                ImageView imageView = findViewById(R.id.toolbar_message_iv);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                        startActivity(intent);
                    }
                });
                break;
        }


    }
}


