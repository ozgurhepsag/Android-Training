package com.example.tipapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etBillAmount;
    private TextView tvTipPercent;
    private TextView tvTipAmount;
    private TextView tvBillTotalAmount;

    float percentage = 0;
    float tipTotal = 0;
    float finalBillAmount = 0;
    float totalBillAmount = 0;

    final static float REGULAR_TIP_PERCENTAGE = 10;
    final static float DEFAULT_TIP_PERCENTAGE = 15;
    final static float EXCELLENT_TIP_PERCENTAGE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBillAmount = findViewById(R.id.etBillAmount);
        tvTipPercent = findViewById(R.id.tvTipPercent);
        tvTipAmount = findViewById(R.id.tvTipAmount);
        tvBillTotalAmount = findViewById(R.id.tvBillTotalAmount);

        displayValues();

        etBillAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!etBillAmount.getText().toString().equals("") && !etBillAmount.getText().toString().equals("."))
                    totalBillAmount = Float.valueOf(etBillAmount.getText().toString());
                else
                    totalBillAmount = 0;

                calculateTip();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void displayValues(){
        tvTipPercent.setText(percentage + " % Tip Percent");
        tvTipAmount.setText("$" + tipTotal + " Tip Total");
        tvBillTotalAmount.setText("$" + finalBillAmount);
    }

    public void setPercentageRegular(View view){
        percentage = REGULAR_TIP_PERCENTAGE;
        calculateTip();
    }

    public void setPercentageExcellent(View view){
        percentage = EXCELLENT_TIP_PERCENTAGE;
        calculateTip();
    }

    public void setPercentageDefault(View view){
        percentage = DEFAULT_TIP_PERCENTAGE;
        calculateTip();
    }

    public void calculateTip(){
        if (percentage == 0)
            percentage = DEFAULT_TIP_PERCENTAGE;

        tipTotal = totalBillAmount * percentage / 100;
        finalBillAmount = tipTotal + totalBillAmount;
        displayValues();
    }
}
