package com.aris.kuryerol.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.helpers.BottomDialog;

public class DeliveredOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered_order);


        Button button = findViewById(R.id.btn_goturdum);

        Button marshrut = findViewById(R.id.btn_marshurut_sg);

        marshrut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveredOrder.this,Marshrut.class);
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

        Button button1 = findViewById(R.id.btn_goturdum);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomDialog dialog = new BottomDialog();
                dialog.showDialog(DeliveredOrder.this, "Sifarişin çatdırılmasını təsdiqlə");

                dialog.btnAccept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DeliveredOrder.this, MainActivity.class);
                        startActivity(intent);
                        dialog.dialog.dismiss();
                    }
                });
            }
        });
    }
}
