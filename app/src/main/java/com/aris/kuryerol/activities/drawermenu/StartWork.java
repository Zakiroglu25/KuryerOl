package com.aris.kuryerol.activities.drawermenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.Authentication;
import com.aris.kuryerol.activities.MainActivity;
import com.aris.kuryerol.activities.Order;


public class StartWork extends AppCompatActivity {

    Button buttonStart;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);


        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);


        buttonStart = findViewById(R.id.buttonStart);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartWork.this, Order.class);
                startActivity(intent);
            }
        });

        buttonStart.setEnabled(false);
        buttonStart.setBackgroundColor(Color.GRAY);
        buttonStart.invalidate();
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                buttonStart.invalidate();
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                buttonStart.invalidate();
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                buttonStart.invalidate();
            }
        });

        checkBox4.setOnClickListener(v -> {
            check();
            buttonStart.invalidate();
        });





    }

    private void check(){
        if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()){
            buttonStart.setEnabled(true);
            buttonStart.getShadowRadius();
            buttonStart.setBackgroundColor(Color.RED);

            final int sdk = android.os.Build.VERSION.SDK_INT;
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                buttonStart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.btn_sifarish_green) );
            } else {
                buttonStart.setBackground(ContextCompat.getDrawable(this, R.drawable.yoxladim_true));
            }
            System.out.println("selected1");



        }else{
            buttonStart.setEnabled(false);
            buttonStart.setBackgroundColor(Color.GRAY);
            System.out.println("selected2");
            final int sdk = android.os.Build.VERSION.SDK_INT;
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                buttonStart.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.btn_sifarish_green) );
            } else {
                buttonStart.setBackground(ContextCompat.getDrawable(this, R.drawable.yoxladim_false));
            }
        }
        buttonStart.invalidate();
    }
}

