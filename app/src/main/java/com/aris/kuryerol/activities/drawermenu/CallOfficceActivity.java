package com.aris.kuryerol.activities.drawermenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aris.kuryerol.R;
import com.google.android.material.snackbar.Snackbar;

public class CallOfficceActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_officce);



    Button telefon = findViewById(R.id.btn_office_call);

    telefon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s = "10digits";

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:123456789"));
            startActivity(callIntent);
        }
    });

    }
}



