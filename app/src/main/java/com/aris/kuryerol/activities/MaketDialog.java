package com.aris.kuryerol.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.drawermenu.StartWork;

public class MaketDialog extends AppCompatActivity {


    Button btnYoxladim;
    CheckBox checkBox5, checkBox6, checkBox7,checkBox8 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maket_dialog);


        Button button = findViewById(R.id.btn_yoxla);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaketDialog.this, OrderAccept.class);
                startActivity(intent);
            }
        });


        btnYoxladim = findViewById(R.id.btn_yoxla);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);


        btnYoxladim.setEnabled(false);
        btnYoxladim.setBackgroundColor(Color.GRAY);

        btnYoxladim.invalidate();
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                btnYoxladim.invalidate();
            }
        });

        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                btnYoxladim.invalidate();
            }
        });

        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                btnYoxladim.invalidate();
            }
        });

    checkBox8.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            check();
            btnYoxladim.invalidate();
        }
    });

}

    private void check(){
        if(checkBox5.isChecked() && checkBox6.isChecked() && checkBox7.isChecked()&& checkBox8.isChecked()){
            btnYoxladim.setEnabled(true);
            btnYoxladim.getShadowRadius();
            btnYoxladim.setBackgroundColor(Color.RED);
            System.out.println("selected1");
        }else{
            btnYoxladim.setEnabled(false);
            btnYoxladim.setTextColor(Color.WHITE);
            btnYoxladim.setBackgroundColor(Color.GRAY);
            System.out.println("selected2");
        }
        btnYoxladim.invalidate();
    }
}