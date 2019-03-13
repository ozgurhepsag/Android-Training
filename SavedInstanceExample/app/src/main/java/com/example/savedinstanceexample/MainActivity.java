package com.example.savedinstanceexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bnDec, bnInc;
    private TextView tvCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnDec = findViewById(R.id.btn_decrement);
        bnInc = findViewById(R.id.btn_increment);
        tvCounter = findViewById(R.id.textView);

        bnDec.setOnClickListener(this);
        bnInc.setOnClickListener(this);

        if (savedInstanceState != null) {
            String counter = savedInstanceState.getString("counter");
            tvCounter.setText(counter);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_decrement:
                decrement();
                break;
            case R.id.btn_increment:
                increment();
                break;
        }
    }

    private void increment() {
        int counter = Integer.parseInt(tvCounter.getText().toString());
        counter++;
        tvCounter.setText(String.valueOf(counter));
    }

    private void decrement() {
        int counter = Integer.parseInt(tvCounter.getText().toString());
        counter--;
        tvCounter.setText(String.valueOf(counter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String counter = tvCounter.getText().toString();
        outState.putString("counter", counter);
    }
}
