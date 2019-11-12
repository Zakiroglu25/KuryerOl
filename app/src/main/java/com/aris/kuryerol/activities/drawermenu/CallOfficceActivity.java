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

         btn = findViewById(R.id.btn_call);
    }
    public void onDialButton(View v) {

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("0558567755"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        startActivity(intent);
    }
}



