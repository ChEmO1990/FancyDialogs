package com.naranya.fancydialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SubscriptionSuccessfulDialog {
    public final static class Builder {
        //Main Context
        private Context mContext;

        //Dialog
        private Dialog dialog;

        private Button accept;

        public Builder( Context context) {
            this.mContext = context;
        }

        public void build() {
            initUI();
        }

        private void initUI() {
            this.dialog = new Dialog(mContext);
            this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.dialog.setContentView(R.layout.dialog_subscription_succesful);
            this.dialog.setCancelable(true);

            //Set configuration of dialog
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.show();
            dialog.getWindow().setAttributes(lp);

            accept = (Button) dialog.findViewById(R.id.btnAccept);
            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

        }
    }
}
