package com.aris.kuryerol.activities.helpers;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.aris.kuryerol.R;

public class OrderDialog {
    public Button btnOrder;
    public Dialog dialog = null;
    public void showDialog(final Activity activity, String text) {

        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_order);
        WindowManager.LayoutParams lp =new WindowManager.LayoutParams();

        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;

        dialog.getWindow().setAttributes(lp);

        dialog.getWindow().setAttributes(lp);


        TextView textView = dialog.findViewById(R.id.textView33);
        textView.setText(text);
        btnOrder = dialog.findViewById(R.id.buttonYoxladimki);
     //   TextView textView =  dialog.findViewById(R.id.textView21);
       // textView.setText(text);
       // btnAccept =  dialog.findViewById(R.id.button_beli);

        Button btnReject = dialog.findViewById(R.id.button8);
        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}

