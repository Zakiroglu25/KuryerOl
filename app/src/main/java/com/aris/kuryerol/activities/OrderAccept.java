package com.aris.kuryerol.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static maes.tech.intentanim.CustomIntent.customType;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.helpers.BottomDialog;

public class OrderAccept extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_accept);


        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);


        Button button = findViewById(R.id.btn_goturdum);

        Button marshrut = findViewById(R.id.btn_marshurut_sg);

        marshrut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderAccept.this,Marshrut.class);
                startActivity(intent);
            }
        });


        Button telefon = findViewById(R.id.btn_telefon_sc);

        telefon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "10digits";

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:123456789"));
                startActivity(callIntent);
            }
        });



        Button buttonb = findViewById(R.id.button3);

        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderAccept.this,MaketDialog.class);
                customType(OrderAccept.this,"fadein-to-fadeout");
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomDialog dialog = new BottomDialog();
                dialog.showDialog(OrderAccept.this, "Sifarişi götürdüyünü təsdiqlə");


                dialog.btnAccept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OrderAccept.this, DeliveredOrder.class);
                        startActivity(intent);
                        dialog.dialog.dismiss();
                    }
                });
            }
        });
    }
}
