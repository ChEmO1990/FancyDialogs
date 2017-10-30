package com.naranya.fancydialogs;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SubscriptionCancelDialog {
    public final static class Builder {
        //Main Context
        private Context mContext;

        //Dialog
        private Dialog dialog;

        private Button btnCancel;
        private Button btnNoRemove;

        public Builder( Context context) {
            this.mContext = context;
        }

        public void build() {
            initUI();
        }

        private void initUI() {
            this.dialog = new Dialog(mContext);
            this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.dialog.setContentView(R.layout.dialog_cancel_subscription);
            this.dialog.setCancelable(true);

            //Set configuration of dialog
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.show();
            dialog.getWindow().setAttributes(lp);

            btnCancel = (Button) dialog.findViewById(R.id.btnCancelSubscription);
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            btnNoRemove = (Button) dialog.findViewById(R.id.btnNoRemoveSubscription);
            btnNoRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }
    }
}
