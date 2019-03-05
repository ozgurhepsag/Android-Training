package com.example.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();

        String message = intent.getStringExtra("EXTRA_MESSAGE");
        TextView textView = findViewById(R.id.display_message);
        textView.setText(message);
    }

    public void openFinalActivity(View view) {

        Intent intent = new Intent(this, FinalActivity.class);

        startActivity(intent);
    }
}
