package com.naranya.fancydialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.TimerTask;

public class ValidatePhoneDialog {
    public final static class Builder {
        //Main Context
        private Context mContext;

        //Dialog
        private Dialog dialog;

        //EditText
        private EditText editText;

        private TextView textTimer;

        //TextWatcher
        private TextWatcher textWatcher;

        private int counter = 0;

        private CountDownTimer timer;

        private Button cancel;
        private Button btnConfirm;

        public Builder( Context context) {
            this.mContext = context;
        }

        public void build() {
            initUI();
        }

        private void initUI() {
            this.dialog = new Dialog(mContext);
            this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.dialog.setContentView(R.layout.validate_pin_phone);
            this.dialog.setCancelable(true);

            textTimer = (TextView) dialog.findViewById(R.id.textTimer);

            editText = (EditText) dialog.findViewById(R.id.editCode);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if( editable.length() == 4 ) {
                        editText.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                    } else {
                        editText.getBackground().clearColorFilter();
                    }
                }
            });

            //Set configuration of dialog
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.show();
            dialog.getWindow().setAttributes(lp);

            new CountDownTimer(2000, 1000) {
                public void onTick(long millisUntilFinished) {}

                public void onFinish() {
                    editText.setText("1234");
                    editText.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                    textTimer.setText("¡Código recibido!");
                }
            }.start();

            cancel = (Button) dialog.findViewById(R.id.btnCancel);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            btnConfirm = (Button) dialog.findViewById(R.id.btnConfirm);
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }
    }
}
