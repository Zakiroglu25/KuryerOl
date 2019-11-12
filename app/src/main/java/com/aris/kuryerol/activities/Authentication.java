package com.aris.kuryerol.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.drawermenu.StartWork;

public class Authentication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        Button button = findViewById(R.id.btnDaxilOl1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Authentication.this, StartWork.class);
                startActivity(intent);
            }
        });
    }
}
