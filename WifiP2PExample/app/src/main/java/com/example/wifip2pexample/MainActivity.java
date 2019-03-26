package com.example.wifip2pexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnOnOff, btnDiscover, btnSend;
    private TextView tvReadMsg, tvConnectionStatus;
    private ListView listView;
    private EditText edtWriteMsg;

    private WifiManager wifiManager;
    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;

    private BroadcastReceiver mReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialWork();
        exqListener();
    }

    private void exqListener() {

        btnOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(wifiManager.isWifiEnabled()){
                    wifiManager.setWifiEnabled(false);
                    btnOnOff.setText("Wifi On");
                }
                else {
                    wifiManager.setWifiEnabled(true);
                    btnOnOff.setText("Wifi Off");
                }

            }
        });

    }

    private void initialWork(){
        btnDiscover = findViewById(R.id.discover_button);
        btnOnOff = findViewById(R.id.onOff_button);
        btnSend = findViewById(R.id.send_button);
        tvReadMsg = findViewById(R.id.readMsg_textView);
        tvConnectionStatus = findViewById(R.id.connectionStatus_textview);
        edtWriteMsg = findViewById(R.id.writeMsg_editText);
        listView = findViewById(R.id.peer_listView);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);

        mReceiver = new WifiDirectBroadcastReceiver(mManager, mChannel, this);
        mIntentFilter = new IntentFilter();

        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}
