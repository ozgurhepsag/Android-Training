package com.example.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


/*
    sendOrderedBroadcast(Intent, String) method sends broadcasts to one receiver at a time.
    sendBroadcast(Intent) method sends broadcasts to all receivers in an undefined order.
    LocalBroadcastManager.sendBroadcast method sends broadcasts to receivers that are in the same app as the sender.
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.broadcast.NEW_BROADCAST");
                intent.putExtra("broadcast","Hello!");
                sendBroadcast(intent);
            }
        });
    }
}
