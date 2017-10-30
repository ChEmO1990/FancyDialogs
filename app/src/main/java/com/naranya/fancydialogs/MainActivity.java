package com.naranya.fancydialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.naranya.npay.NPay;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        new NPay.NPayBuilder().createSubscription()
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                new SubscriptionDialog.Builder(this).build();
                break;

            case R.id.btn2:
                new PhoneInputDialog.Builder(this).build();
                break;

            case R.id.btn3:
                new PhoneInputShortDialog.Builder(this).build();
                break;

            case R.id.btn4:
                new ValidatePhoneDialog.Builder(this).build();
                break;

            case R.id.btn5:
                new SubscriptionSuccessfulDialog.Builder(this).build();
                break;

            case R.id.btn6:
                new SubscriptionCancelDialog.Builder(this).build();
                break;
        }
    }
}