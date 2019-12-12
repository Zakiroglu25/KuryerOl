package com.aris.kuryerol.activities.helpers;


import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aris.kuryerol.R;

public class BottomDialog extends Dialog {

    public Button btnAccept;

    public BottomDialog(@NonNull Context context) {
        super(context);
        init();

    }

    public BottomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();

    }

    protected BottomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }


    private void init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(false);
        setContentView(R.layout.bottom_dialog_ordee_accepted);

        findViewById(R.id.button8).setOnClickListener(v -> dismiss());
    }

    public BottomDialog setTitle(String title) {
        ((TextView) findViewById(R.id.textView21)).setText(title);
        return this;
    }

    public static BottomDialog from(Context context){
        return  new BottomDialog(context);
    }

    public BottomDialog setOnAcceptListener(Runnable runnable) {
        findViewById(R.id.button_beli).setOnClickListener(v -> {
            dismiss();
            runnable.run();
        });
        return this;
    }
    public void showDialog(Context context, String text) {




    }
}
