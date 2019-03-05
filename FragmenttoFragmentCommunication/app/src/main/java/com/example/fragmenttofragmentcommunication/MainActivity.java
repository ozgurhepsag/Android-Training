package com.example.fragmenttofragmentcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null)
                return;

            MessageFragment messageFragment = new MessageFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, messageFragment, null);
            fragmentTransaction.commit();


        }
    }

    @Override
    public void onMessageSend(String message) {
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        displayFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, displayFragment, null).addToBackStack(null);
        fragmentTransaction.commit();
    }
}
