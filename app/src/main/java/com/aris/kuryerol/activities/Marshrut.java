package com.aris.kuryerol.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aris.kuryerol.R;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class Marshrut extends AppCompatActivity {

    private MapView mapview;

    // Specify the name of the activity in place of map.    setContentView (R. layout.map);
    //
    private final String MAPKIT_API_KEY = "b7f7137a-58ad-44ce-8612-76b1910cfc0d";
    private final Point TARGET_LOCATION = new Point(59.945933, 30.320045);

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);


        setContentView(R.layout.activity_marshrut);


        // todo imtina et altinnan xett(underline)
        TextView textView = findViewById(R.id.textView20 ) ;
        SpannableString content = new SpannableString( "Imtina et" ) ;
        content.setSpan( new UnderlineSpan() , 0 , content.length() , 0 ) ;
      //  textView.setText(content) ;


        mapview = findViewById(R.id.mapview);

        mapview.getMap().move(
                new CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);

        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);


        myChildToolbar.setNavigationOnClickListener(view -> onBackPressed());

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    protected void onStop() {
        // Activity onStop call must be passed to both MapView and MapKit instance.
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Activity onStart call must be passed to both MapView and MapKit instance.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapview.onStart();
    }

}

