package com.aris.kuryerol.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.helpers.BottomDialog;

public class OrderAccept extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_accept);

        Button button = findViewById(R.id.btn_goturdum);

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
