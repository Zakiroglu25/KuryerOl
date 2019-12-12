package com.aris.kuryerol.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


import com.aris.kuryerol.R;
import com.aris.kuryerol.activities.helpers.BottomDialog;

public class OrderAccept extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;

    private static final String TAG = "OrderAccept";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_accept);


        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        myChildToolbar.setNavigationOnClickListener((view)-> onBackPressed());

    }


    private void action(Button btn_yoxla, CheckBox ch1, CheckBox ch2, CheckBox ch3, CheckBox ch4) {
        if (ch1.isChecked() && ch2.isChecked() && ch3.isChecked() && ch4.isChecked()) {
            btn_yoxla.setEnabled(true);
            btn_yoxla.setBackgroundColor(Color.RED);

            final int sdk = android.os.Build.VERSION.SDK_INT;
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                btn_yoxla.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.btn_sifarish_green));
            } else {
                btn_yoxla.setBackground(ContextCompat.getDrawable(this, R.drawable.yoxladim_true));
            }


            btn_yoxla.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            btn_yoxla.setEnabled(false);
            btn_yoxla.setBackgroundColor(Color.parseColor("#C5C5C5"));
            btn_yoxla.setTextColor(Color.parseColor("#A51D39"));


            final int sdk = android.os.Build.VERSION.SDK_INT;
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                btn_yoxla.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.btn_sifarish_green));
            } else {
                btn_yoxla.setBackground(ContextCompat.getDrawable(this, R.drawable.yoxladim_false));
            }
        }
    }

    void showDialog() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.alert_dialog, null);

        Button btn_yoxla = view.findViewById(R.id.btn_yoxla);
        CheckBox ch1 = view.findViewById(R.id.checkBox5);
        CheckBox ch2 = view.findViewById(R.id.checkBox6);
        CheckBox ch3 = view.findViewById(R.id.checkBox7);
        CheckBox ch4 = view.findViewById(R.id.checkBox8);

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(btn_yoxla, ch1, ch2, ch3, ch4);
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(btn_yoxla, ch1, ch2, ch3, ch4);
            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(btn_yoxla, ch1, ch2, ch3, ch4);
            }
        });

        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(btn_yoxla, ch1, ch2, ch3, ch4);
            }
        });


        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();

        alertDialog.show();


        btn_yoxla.setOnClickListener(view1 -> {
            Log.e(TAG, "onClick: accept button");
            alertDialog.dismiss();


        });



    }


    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_telefon_sc:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:123456789"));
                startActivity(intent);
                break;
            case R.id.btn_marshurut_sg:
                intent = new Intent(OrderAccept.this, Marshrut.class);
                startActivity(intent);

                break;
            case R.id.buttonsifa:
                showDialog();
                break;

            case R.id.btn_goturdum:
                BottomDialog.from(this).setTitle("Sifarişi götürdüyünü təsdiqlə").setOnAcceptListener(() -> {
                    Intent deIntent = new Intent(OrderAccept.this, DeliveredOrder.class);
                    startActivity(deIntent);
                }).show();

                break;
        }

    }
}
