package com.naranya.fancydialogs;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SubscriptionDialog {
    public final static class Builder {
        //Main Context
        private Context mContext;

        //Dialog
        private Dialog dialog;

        private Button btnSubscribed;
        private Button btnCraete;
        private TextView terms;

        public Builder( Context context) {
            this.mContext = context;
        }

        public void build() {
            initUI();
        }

        private void initUI() {
            this.dialog = new Dialog(mContext);
            this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.dialog.setContentView(R.layout.dialog_detail_subscription);
            this.dialog.setCancelable(true);

            //Set configuration of dialog
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.show();
            dialog.getWindow().setAttributes(lp);

            terms = (TextView) dialog.findViewById(R.id.lbl_terms);

            btnSubscribed = (Button) dialog.findViewById(R.id.btnSubscribed);
            btnSubscribed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            btnCraete = (Button) dialog.findViewById(R.id.btnCreateSubscription);
            btnCraete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            String value = "<html>Al suscribirte aceptas los <a href=\"https://npay.io/TyC/MX/AMX/es.html\">términos y condiciones.</a></html>";
            terms.setText(Html.fromHtml(value));

            terms.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
