package com.naranya.fancydialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhoneInputDialog {
    public final static class Builder {
        //Main Context
        private Context mContext;

        //Dialog
        private Dialog dialog;

        //EditText
        private EditText editText;

        //TextWatcher
        private TextWatcher textWatcher;

        private int counter = 0;

        private Button btnCancel;
        private Button btnContinue;

        private Spinner spinner1;
        private Spinner spinner2;

        private List<String> spinnerArray1 =  new ArrayList<String>();
        private List<String> spinnerArray2 =  new ArrayList<String>();

        private ArrayAdapter<String> adapter1;
        private ArrayAdapter<String> adapter2;

        public Builder( Context context) {
            this.mContext = context;
        }

        public void build() {
            initUI();
        }

        private void initUI() {
            this.dialog = new Dialog(mContext);
            this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.dialog.setContentView(R.layout.phone_input_dialog);
            this.dialog.setCancelable(true);

            spinner1 = (Spinner) dialog.findViewById(R.id.spinner1);
            spinner2 = (Spinner) dialog.findViewById(R.id.spinner2);

            editText = (EditText) dialog.findViewById(R.id.editText);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if( editable.length() == 10 ) {
                        editText.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                    } else {
                        editText.getBackground().clearColorFilter();
                    }
                }
            });

            btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            btnContinue = (Button) dialog.findViewById(R.id.btnContinue);
            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            //Set configuration of dialog
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.show();
            dialog.getWindow().setAttributes(lp);

            spinnerArray1.add("México");
            spinnerArray1.add("Peru");
            spinnerArray1.add("Argentina");
            spinnerArray1.add("Colombia");
            spinnerArray1.add("Brasil");
            spinnerArray1.add("Puerto Rico");
            spinnerArray1.add("Honduras");
            spinnerArray1.add("Costa Rica");

            spinnerArray2.add("Telcel");
            spinnerArray2.add("Claro");

            adapter1= new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, spinnerArray1);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            adapter2 = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, spinnerArray2);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(adapter1);
            spinner2.setAdapter(adapter2);
        }
    }
}
